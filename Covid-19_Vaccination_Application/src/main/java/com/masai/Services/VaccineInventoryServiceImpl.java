package com.masai.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.VaccineCentreException;
import com.masai.Exception.VaccineException;
import com.masai.Exception.VaccineInventoryException;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.VaccinationCenter;
import com.masai.Model.VaccineCount;
import com.masai.Model.VaccineInventory;
import com.masai.Repository.AdminSessionRepository;
import com.masai.Repository.VaccineCenterRepository;
import com.masai.Repository.VaccineCountRepository;
import com.masai.Repository.VaccineInventoryReposistory;


@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService {
	@Autowired
	private VaccineInventoryReposistory vaccineInvDao;

	@Autowired
	private VaccinationCenterService vaccineCenterService;

	@Autowired
	private VaccineCountRepository vaccinecountdao;

	@Autowired
	private VaccineCenterRepository vctDao;
	
	@Autowired
	private AdminSessionRepository adminSessionDAO;

	@Override
	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key) throws VaccineInventoryException {
		
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		Optional<VaccineInventory> opt = vaccineInvDao.findById(vaccineInv.getVaccineInventoryId());
		if (opt.isPresent()) {
			throw new VaccineInventoryException("VaccineInventory already exists!");
		}


		List<VaccinationCenter> vaccineCenterList = vaccineInv.getVaccinationCanter();
		for (VaccinationCenter vaccinationCenter : vaccineCenterList) {
			vaccinationCenter.setVaccineInventory(vaccineInv);

		}

		List<VaccineCount> vaccinecountList = vaccineInv.getVaccinecount();
		for (VaccineCount vaccineCount : vaccinecountList) {
			vaccineCount.setVaccineInventory(vaccineInv);

		}
		return vaccineInvDao.save(vaccineInv);

	}

	@Override
	public List<VaccineInventory> allVaccineInventory(String key) throws VaccineInventoryException {

		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		List<VaccineInventory> vaccineInventoryList = vaccineInvDao.findAll();
		if (vaccineInventoryList.size() > 0) {
			return vaccineInventoryList;
		}
		throw new VaccineInventoryException("List empty, need to add Inventory first!");

	}

	@Override
	public VaccineInventory getVaccineInventoryByCenter(Integer centerid,String key) throws VaccineInventoryException, VaccineCentreException {

		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		VaccinationCenter vc = vaccineCenterService.getVaccineCenter(centerid,key);
		if (vc == null) {
			throw new VaccineInventoryException("Vaccine Inventory not found!");
		}
		return vc.getVaccineInventory();
	}

	@Override
	public VaccineInventory addVaccineCount(VaccineInventory inv, Integer vaccineId,String key) throws VaccineInventoryException, VaccineException {
		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		Optional<VaccineInventory> opt = vaccineInvDao.findById(inv.getVaccineInventoryId());

		if (opt.isPresent()) {
			VaccineInventory vacInv = opt.get();

			List<VaccineCount> vcList = vacInv.getVaccinecount();
			int count = 0;
			for (VaccineCount vaccineCount : vcList) {
				if (vaccineCount.getVaccine() != null) {
					if (vaccineCount.getVaccine().getVaccineId() == vaccineId) {
						count++;
						vaccineCount.setQuantity(vaccineCount.getQuantity() + 1);
					}
				}
			}
			if (count == 0) {
				throw new VaccineException("Vaccine not found by id: " + vaccineId);
			}
			return vaccineInvDao.save(vacInv);
		}
		throw new VaccineInventoryException("Vaccine Inventory not found!");

	}

	
	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineInv,String key) throws VaccineInventoryException {
		
		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		Optional<VaccineInventory> vacInvOpt = vaccineInvDao.findById(vaccineInv.getVaccineInventoryId());
		if (vacInvOpt.isPresent()) {

			// saving vaccine count and centers
			List<VaccinationCenter> vaccineCenterList = vaccineInv.getVaccinationCanter();
			for (VaccinationCenter vaccinationCenter : vaccineCenterList) {
				vctDao.save(vaccinationCenter);
				vaccinationCenter.setVaccineInventory(vaccineInv);
			}

			List<VaccineCount> vaccinecountList = vaccineInv.getVaccinecount();
			for (VaccineCount vaccineCount : vaccinecountList) {
				vaccinecountdao.save(vaccineCount);
				vaccineCount.setVaccineInventory(vaccineInv);
			}
			// till here
			return vaccineInvDao.save(vaccineInv);
		}
		throw new VaccineInventoryException("Vaccine Inventory not found!");

	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory inv,String key) throws VaccineInventoryException {


		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		boolean flag = false;

		Optional<VaccineInventory> vacInvOpt = vaccineInvDao.findById(inv.getVaccineInventoryId());
		if (vacInvOpt.isPresent()) {
			flag = true;
			VaccineInventory vacInv = vacInvOpt.get();
			vaccineInvDao.delete(vacInv);
			return flag;
		}
		throw new VaccineInventoryException("Vaccine Inventory not found!");

	}

	
	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date,String key) throws VaccineInventoryException {

		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		List<VaccineInventory> vacInvList = vaccineInvDao.findByDate(date);
		if (vacInvList.size() > 0) {
			return vacInvList;
		}
		throw new VaccineInventoryException("No Vaccine Inventory found!");
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(String vaccineName,String key) throws VaccineInventoryException, VaccineException {

		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		List<VaccineInventory> vaccineInventoryList = vaccineInvDao.findAll();
		if (vaccineInventoryList.size() == 0) {
			throw new VaccineInventoryException("List empty, need to add Inventory first!");
		}
		List<VaccineInventory> foundedvaccineInventoryList = new ArrayList<>();
		int count = 0;
		for (VaccineInventory vaccineInventory : vaccineInventoryList) {

			List<VaccineCount> vaccineCountList = vaccineInventory.getVaccinecount();
			if (vaccineCountList.size() == 0) {
				throw new VaccineInventoryException("List empty, need to add VaccineCount first!");
			}

			for (VaccineCount vaccineCount : vaccineCountList) {

				if (!(vaccineCount.getVaccine() == null)) {
					if (vaccineCount.getVaccine().getVaccinename().equalsIgnoreCase(vaccineName)) {
						foundedvaccineInventoryList.add(vaccineInventory);
						count++;
					}
				}
			}
		}
		if (count == 0) {
			throw new VaccineException("Vaccine not found by name: " + vaccineName);
		}

		return foundedvaccineInventoryList;
	}

	
}
