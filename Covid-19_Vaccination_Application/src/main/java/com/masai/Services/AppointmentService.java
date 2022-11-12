package com.masai.Services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Exception.AppointmentException;
import com.masai.Model.Appointment;

public interface AppointmentService extends JpaRepository<Appointment, Integer> {
	
	public List<Appointment> getAllAppointment(String key)throws AppointmentException;

	public Appointment getAppointmentByBookingId(Long bookingId,String key)throws AppointmentException;

	public Appointment addAppointment(Appointment app, Integer memId,String key)throws AppointmentException;

	public Appointment updateAppointment(Appointment app,String key)throws AppointmentException;

	public boolean deleteAppointment(Long bookingId,String key)throws AppointmentException;
	
}
