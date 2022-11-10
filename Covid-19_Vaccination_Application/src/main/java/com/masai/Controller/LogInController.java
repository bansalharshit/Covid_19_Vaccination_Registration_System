package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.LoginException;
import com.masai.Model.LogInDTO;
import com.masai.Services.LoginService;

@RestController
public class LogInController {

	@Autowired
	private LoginService userLoginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@Valid @RequestBody LogInDTO dto) throws LoginException {
		
		String result = userLoginService.logInToAccount(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		return userLoginService.logOutFromAccount(key);
		
	}
	
}
