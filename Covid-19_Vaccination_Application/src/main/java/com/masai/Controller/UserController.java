package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Model.UserDto;
import com.masai.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

//	@Autowired
//	private AppointmentService aService;
//	
//	@PostMapping("/appointment")
//	public ResponseEntity<Appointment> addAppointmentController(@RequestBody Appointment app) throws AppointmentException {
//		Appointment appointment=aService.addAppointment(app);
//		return new ResponseEntity<Appointment>(appointment,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/appointment/{bid}")
//	public ResponseEntity<Appointment> getAppointmentByBookingIdHandler(@PathVariable("bid") Long bookingId) throws AppointmentException{
//		return new ResponseEntity<Appointment>(aService.getAppointment(bookingId),HttpStatus.FOUND);
//	}
	@GetMapping("/welcome/")
	private ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome",HttpStatus.OK);
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
