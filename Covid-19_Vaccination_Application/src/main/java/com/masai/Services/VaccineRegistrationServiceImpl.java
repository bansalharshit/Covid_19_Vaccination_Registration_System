package com.masai.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.VaccineRegistrationException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Member;
import com.masai.Model.VaccineRegistration;
import com.masai.Repository.UserSessionRepository;
import com.masai.Repository.VaccineRegistrationRepository;


@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

	@Autowired
	private VaccineRegistrationRepository vaccineRegistrationDao;

	@Autowired
	private VaccineRegistrationRepository vrdao;
	
	@Autowired
	private UserSessionRepository userSessionDAO;

	@Override
	public List<VaccineRegistration> allVaccineRegistration()throws VaccineRegistrationException {
		List<com.masai.Model.VaccineRegistration> vaccineRegAll = vaccineRegistrationDao.findAll();

		if (vaccineRegAll.size() > 0)
			return vaccineRegAll;
		else
			throw new RuntimeException("No VaccineRegistration found...");
	}

	
	@Override
	public List<Member> getAllMember(String mobileNo,String key) throws VaccineRegistrationException {
		
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new VaccineRegistrationException("Unauthorised access");
			}
	
		
		Optional<VaccineRegistration> vr = vrdao.findById(mobileNo);
		if (vr.isPresent()) {
			VaccineRegistration reg = vr.get();
			return reg.getMembers();
		} else
			throw new VaccineRegistrationException("Registration Not Found....");
	}

	@Override
	public VaccineRegistration addVaccineRegistration(String mobNo,String key) throws VaccineRegistrationException {

		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new VaccineRegistrationException("Unauthorised access");
			}
			
		Optional<VaccineRegistration> vr = vaccineRegistrationDao.findById(mobNo);

		if (vr.isPresent()) {
			throw new VaccineRegistrationException("Vaccination registration is present with the same MobileNo");
		}
		return vaccineRegistrationDao.save(new VaccineRegistration(mobNo, LocalDate.now(), null));
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(String mobNo, String newMobNo,String key) throws VaccineRegistrationException {

		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new VaccineRegistrationException("Unauthorised access");
			}
	
		
		VaccineRegistration vc = vaccineRegistrationDao.findById(mobNo)
				.orElseThrow(() -> new VaccineRegistrationException("Registration not found"));
		vc.setMobileNo(newMobNo);
		return vaccineRegistrationDao.save(vc);

	}

	@Override
	public boolean deleteVaccineRegistration(String mobNo,String key) throws VaccineRegistrationException {
		
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new VaccineRegistrationException("Unauthorised access");
			}
	
		
		VaccineRegistration vr = vaccineRegistrationDao.findById(mobNo)
				.orElseThrow(() -> new VaccineRegistrationException("Vaccine Registration Not Found"));
		vaccineRegistrationDao.delete(vr);
		return true;

	}


	@Override
	public VaccineRegistration getVaccineRegistration(String mobileNo, String key) throws VaccineRegistrationException {
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new VaccineRegistrationException("Unauthorised access");
			}
	
		
		return vaccineRegistrationDao.findById(mobileNo).orElseThrow(() -> new VaccineRegistrationException(
				"VaccineRegistraion does not exist with this mobileNo :" + mobileNo));
	}


	

	




}