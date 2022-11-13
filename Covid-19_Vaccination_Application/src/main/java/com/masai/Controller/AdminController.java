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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Model.Admin;
import com.masai.Model.AdminDto;
import com.masai.Services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@GetMapping("/welcome")
	private ResponseEntity<String> welcomeAdmin(){
		return new ResponseEntity<String>("Welcome",HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	private ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin) throws UserException{
		Admin newAdmin = adminService.createNewAdmin(admin);
		
		return new ResponseEntity<Admin>(newAdmin,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	private ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin,@RequestParam(required = true) String password) throws UserException{
		Admin savedAdmin = adminService.updateAdmin(admin, password);
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	private ResponseEntity<Admin> removeAdmin(@Valid @RequestBody AdminDto aDto) throws UserException{
		
		Admin removedAdmin = adminService.removeAdmin(aDto);
		
		return new ResponseEntity<Admin>(removedAdmin,HttpStatus.OK);
	}

}
