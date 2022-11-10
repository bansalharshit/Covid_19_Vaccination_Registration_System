package com.masai.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AppointmentException;
import com.masai.Model.Appointment;
import com.masai.Repository.AppointmentRepo;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo aRepo;
	
	@Override
	public List<Appointment> allAppointment() throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment getAppointment(long bookingId) throws AppointmentException {
	return aRepo.findById(bookingId).orElseThrow(()->new AppointmentException("Appointment is not Avaible with bookingId "+bookingId));
	}

	@Override
	public Appointment addAppointment(Appointment app) throws AppointmentException {
	Appointment appointment=aRepo.save(app);
	return appointment;
	}

	@Override
	public Appointment updateAppointment(Appointment app) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment deleteAppointment(Appointment app) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

}
