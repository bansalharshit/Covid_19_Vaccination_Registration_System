package com.masai.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Exception.VaccineException;
import com.masai.Model.Vaccine;



@Service
public interface VaccineService {

	public List<Vaccine> allVaccine(String key)throws VaccineException;

	public Vaccine getVaccineByName(String VaccineName,String key)throws VaccineException;

	public Vaccine getVaccineById(Integer vaccineId,String key)throws VaccineException;

	public Vaccine addVaccine(Vaccine vaccine,String key)throws VaccineException;

	public Vaccine updateVaccine(Vaccine vaccine,String key)throws VaccineException;

	public boolean deleteVaccine(Vaccine vaccine,String key)throws VaccineException;

}

