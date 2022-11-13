package com.masai.Services;

import java.time.LocalDate;
import java.util.List;

import com.masai.Exception.VaccineCentreException;
import com.masai.Exception.VaccineException;
import com.masai.Exception.VaccineInventoryException;
import com.masai.Model.VaccineInventory;



public interface VaccineInventoryService {
	
	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key)throws VaccineInventoryException;

	public List<VaccineInventory> allVaccineInventory(String key)throws VaccineInventoryException;
	
	public VaccineInventory getVaccineInventoryByCenter(Integer centerid,String key)throws VaccineInventoryException, VaccineCentreException;
	
	public  VaccineInventory addVaccineCount(VaccineInventory inv,Integer vaccineId,String key)throws VaccineInventoryException, VaccineException;
	
	public VaccineInventory updateVaccineInventory(VaccineInventory inv,String key)throws VaccineInventoryException;

	public boolean deleteVaccineInventory(VaccineInventory inv,String key)throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date,String key)throws VaccineInventoryException;
	
	public List<VaccineInventory> getVaccineInventoryByVaccine(String vaccineName,String key)throws VaccineInventoryException, VaccineException;
}
