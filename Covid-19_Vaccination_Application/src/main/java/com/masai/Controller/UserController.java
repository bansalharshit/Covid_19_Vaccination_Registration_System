package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices uService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome !",HttpStatus.OK);
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws UserException{
		User  newUser = uService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @RequestParam(required = false) String key) throws UserException {
		User updatedUser = uService.updateUser(user, key);
		
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	
}
