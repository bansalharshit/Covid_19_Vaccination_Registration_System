package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AppointmentException;
import com.masai.Model.Appointment;
import com.masai.Services.AppointmentService;

@RestController
public class UserController {

	@Autowired
	private AppointmentService aService;
	
	@PostMapping("/appointment")
	public ResponseEntity<Appointment> addAppointmentController(@RequestBody Appointment app) throws AppointmentException {
		Appointment appointment=aService.addAppointment(app);
		return new ResponseEntity<Appointment>(appointment,HttpStatus.CREATED);
	}
	
	@GetMapping("/appointment/{bid}")
	public ResponseEntity<Appointment> getAppointmentByBookingIdHandler(@PathVariable("bid") Long bookingId) throws AppointmentException{
		return new ResponseEntity<Appointment>(aService.getAppointment(bookingId),HttpStatus.FOUND);
	}
	
}
