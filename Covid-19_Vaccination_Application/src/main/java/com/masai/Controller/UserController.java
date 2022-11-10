package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/user/signUp")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException{
		User  newUser = uService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.ACCEPTED);
	}
	
}
