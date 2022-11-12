package com.masai.Services;

import java.util.List;

import com.masai.Exception.AppointmentException;
import com.masai.Model.Appointment;

public interface AppointmentService {
public List<Appointment> allAppointment() throws AppointmentException;
public Appointment getAppointment(long bookingId)throws AppointmentException;
public Appointment addAppointment(Appointment app)throws AppointmentException;
public Appointment updateAppointment(Appointment app)throws AppointmentException;
public Appointment deleteAppointment(Appointment app)throws AppointmentException;
}
