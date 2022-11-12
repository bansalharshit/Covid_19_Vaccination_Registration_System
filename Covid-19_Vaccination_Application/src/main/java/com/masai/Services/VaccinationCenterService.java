package com.masai.Services;

import java.util.List;

import com.masai.Exception.VaccineCentreException;
import com.masai.Model.VaccinationCenter;



public interface VaccinationCenterService {

	public List<VaccinationCenter> allVaccineCenters(String key) throws VaccineCentreException;

	public VaccinationCenter getVaccineCenter(Integer centerid,String key) throws VaccineCentreException;

	public VaccinationCenter addVaccineCenter(VaccinationCenter center,String key) throws VaccineCentreException;

	public VaccinationCenter updateVaccineCenter(VaccinationCenter center,String key) throws VaccineCentreException;

	public boolean deleteVaccineCenter(VaccinationCenter center,String key) throws VaccineCentreException;
}
