//package com.masai.Services;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.masai.Exception.AppointmentException;
//import com.masai.Exception.MemberException;
//import com.masai.Exception.VaccineCentreException;
//import com.masai.Exception.VaccineRegistrationException;
//import com.masai.Model.Appointment;
//
//public interface AppointmentService{
//	
//	public List<Appointment> getAllAppointment(String key)throws AppointmentException;
//
//	
//
//	public Appointment addAppointment(Appointment appointment, Integer memberId,String key)throws AppointmentException, VaccineCentreException, VaccineRegistrationException, MemberException;
//
//	
//	public boolean deleteAppointment(Long bookingId,String key)throws AppointmentException;
//	
//}
