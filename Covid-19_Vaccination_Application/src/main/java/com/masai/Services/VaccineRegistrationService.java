package com.masai.Services;

import java.util.List;

import com.masai.Exception.VaccineRegistrationException;
import com.masai.Model.Member;
import com.masai.Model.VaccineRegistration;



public interface VaccineRegistrationService {

	public List<VaccineRegistration> allVaccineRegistration()throws VaccineRegistrationException;

	public VaccineRegistration getVaccineRegistration(String mobNo,String key)throws VaccineRegistrationException;

	public List<Member> getAllMember(String mobileNo,String key) throws VaccineRegistrationException;

	public VaccineRegistration addVaccineRegistration(String mobNo,String key)throws VaccineRegistrationException;

	public VaccineRegistration updateVaccineRegistration(String mobNo, String newMobNo,String key)throws VaccineRegistrationException;

	public boolean deleteVaccineRegistration(String mobNo,String key)throws VaccineRegistrationException;

	

	

}
