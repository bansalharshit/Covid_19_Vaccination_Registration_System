package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.VaccineException;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Vaccine;
import com.masai.Repository.AdminSessionRepository;
import com.masai.Repository.UserSessionRepository;

import com.masai.Repository.VaccineRepository;



@Service

public class VaccineServiceImpl implements VaccineService {


	@Autowired
	private VaccineRepository dao;
	
	@Autowired
	private AdminSessionRepository adminSessionDAO;
	
	@Autowired
	private UserSessionRepository userSessionDAO;

	@Override
	public List<Vaccine> allVaccine(String key)throws VaccineException {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			
		List<Vaccine> list = dao.findAll();

		if (list.size() > 0)
			return list;
		else
			throw new VaccineException("No Vaccines Available");
	}

	@Override
	public Vaccine getVaccineByName(String VaccineName,String key) throws VaccineException {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		
		Optional<Vaccine> vaccine = dao.findByvaccinename(VaccineName);
		
		if(vaccine != null) return vaccine.get();
		else throw new VaccineException("Vaccine with name " + VaccineName + " in not available");

	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId,String key) throws VaccineException {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> opt = dao.findById(vaccineId);

		if (opt.isPresent())
			return opt.get();

		else
			throw new VaccineException("Vaccine with Id " + vaccineId + " is not available");
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine,String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> vacc = dao.findByvaccinename(vaccine.getVaccinename());
		
		if(vacc.get() == null) {


            return dao.save(vaccine);
		}
		throw new RuntimeException("Vaccine already exists!");
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine,String key) throws VaccineException {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> opt = dao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {
			return dao.save(vaccine);
		} else
			throw new VaccineException("The vaccine you want to update does not exist!");
	}

	@Override
	public boolean deleteVaccine(Vaccine vaccine,String key) throws VaccineException {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> opt = dao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {
			dao.delete(vaccine);
			return true;
		} else
			throw new VaccineException("The vaccine you want to delete does not exist!");
	}



}
