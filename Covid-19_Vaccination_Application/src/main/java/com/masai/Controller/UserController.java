package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AppointmentException;
import com.masai.Exception.MemberException;
import com.masai.Exception.UserException;
import com.masai.Exception.VaccineCentreException;
import com.masai.Exception.VaccineRegistrationException;
import com.masai.Model.Appointment;
import com.masai.Model.User;
import com.masai.Model.UserDto;
import com.masai.Services.AppointmentService;
import com.masai.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private AppointmentService aService;
	
	@GetMapping("/welcome/")
	private ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome",HttpStatus.OK);
	}
	
	@PostMapping("/appointment/{memId}")
	public ResponseEntity<Appointment> bookAppointment(@PathVariable("memId") Integer memId,
			@RequestBody Appointment appointment,@RequestParam String key) throws AppointmentException, VaccineCentreException, VaccineRegistrationException, MemberException {
		Appointment a = aService.addAppointment(appointment, memId,key);
		return new ResponseEntity<Appointment>(a, HttpStatus.CREATED);
	}

//	@GetMapping("/appointment/{id}")
//	public ResponseEntity<Appointment> getAppointment(@PathVariable("id") Long bookingId,@RequestParam String key) throws AppointmentException {
//		return new ResponseEntity<Appointment>(aService.getAppointmentByBookingId(bookingId,key),
//				HttpStatus.FOUND);
//	}

//	@PutMapping("/appointment")
//	public ResponseEntity<Appointment> updateVaccineAppointment(@RequestBody Appointment app,@RequestParam String key) throws AppointmentException {
//		return new ResponseEntity<Appointment>(aService.updateAppointment(app,key), HttpStatus.OK);
//	}

	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<Boolean> deleteVaccineAppointment(@PathVariable("id") Long bookingId,@RequestParam String key) throws AppointmentException {
		return new ResponseEntity<Boolean>(aService.deleteAppointment(bookingId,key), HttpStatus.OK);
	}
	
	
	@PostMapping("/user/signup/")
	private ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException{
		User newUser = userService.createNewUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/user/update/")
	private ResponseEntity<User> updateUser(@Valid @RequestBody User user,@RequestParam(required = true) String password) throws UserException{
		User savedUser = userService.updateUser(user, password);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user/delete/")
	private ResponseEntity<User> removeUser(@Valid @RequestBody UserDto uDto) throws UserException{
		
		User removedUser = userService.removeUser(uDto);
		
		return new ResponseEntity<User>(removedUser,HttpStatus.OK);
	}
	
}
