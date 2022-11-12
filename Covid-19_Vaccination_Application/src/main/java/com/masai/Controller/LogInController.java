package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.LoginException;
import com.masai.Model.AdminDto;
import com.masai.Model.UserDto;
import com.masai.Services.LoginServices;

@RestController
public class LogInController {

	@Autowired
	private LoginServices login;
	
	@PostMapping("/user/login")
	public ResponseEntity<String> logInUser(@Valid @RequestBody UserDto udto) throws LoginException {
		
		String result = login.logInToUserAccount(udto);

		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@GetMapping("/user/logout")
	public String logoutUser(@RequestParam(required = true) String key) throws LoginException {
		return login.logOutFromUserAccount(key);
		
	}
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> logInAdmin(@Valid @RequestBody AdminDto adto) throws LoginException {
		
		String result = login.logInToAdminAccount(adto);

		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@GetMapping("/admin/logout")
	public String logoutADmin(@RequestParam(required = true) String key) throws LoginException {
		return login.logOutFromAdminAccount(key);
		
	}
	
	
}
