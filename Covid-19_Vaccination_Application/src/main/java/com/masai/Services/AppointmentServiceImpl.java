package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AppointmentException;
import com.masai.Exception.MemberException;
import com.masai.Exception.VaccineCentreException;
import com.masai.Exception.VaccineRegistrationException;
import com.masai.Model.Appointment;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Member;
import com.masai.Model.VaccinationCenter;
import com.masai.Model.VaccineRegistration;
import com.masai.Repository.AdminSessionRepository;
import com.masai.Repository.AppointmentRepo;
import com.masai.Repository.UserSessionRepository;


@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo appointmentDao;

	@Autowired
	private VaccineRegistrationService registrationService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	
	@Autowired
	private AdminSessionRepository adminSessionDAO;
	
	@Autowired
	private UserSessionRepository userSessionDAO;
	
	
	@Override
	public List<Appointment> getAllAppointment(String key) throws AppointmentException {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new AppointmentException("Unauthorised access");
			}
			
		List<Appointment> appointments = appointmentDao.findAll();
		if (appointments.size() > 0)
			return appointments;
		else
			throw new AppointmentException("No appointment found");
	}

	

	@Override
	public Appointment addAppointment(Appointment appointment, Integer memberId, String key)
			throws AppointmentException, VaccineCentreException, VaccineRegistrationException, MemberException {
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	

		VaccineRegistration reg = registrationService.getVaccineRegistration(appointment.getMobileNo(),key);
		if (reg == null)
			throw new AppointmentException("First do the registration...");
		else {
			List<Member> list = reg.getMembers();
			for (Member m : list) {
				if (m.getMemberid() == memberId) {
					appointment.setMember(m);
					appointment.setDateofbooking(LocalDate.now());
					appointment.setBookingStatus(true);
					Integer id = appointment.getVaccinationCenter().getCode();
					VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccineCenter(id,key);
					appointment.setVaccinationCenter(vaccinationCenter);
					Appointment a = appointmentDao.save(appointment);
					m.getAppointments().add(a);
					memberService.updateMember(m, m.getMemberid(),key);
					return a;
				}
			}
			throw new AppointmentException("Member not found...");
		}
	}

	
	@Override
	public boolean deleteAppointment(Long bookingId, String key) throws AppointmentException {
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new AppointmentException("Unauthorised access");
			}
			
		Appointment ExitApp = appointmentDao.findById(bookingId)
				.orElseThrow(() -> new AppointmentException("Appointment not found!"));
		appointmentDao.delete(ExitApp);
		return true;
	}

	

}
