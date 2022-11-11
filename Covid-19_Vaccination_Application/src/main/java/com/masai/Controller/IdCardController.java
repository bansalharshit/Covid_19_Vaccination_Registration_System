package com.masai.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.IdCardException;
import com.masai.Model.IDCard;
import com.masai.Services.IDcardServices;

@RestController
public class IdCardController {

	@Autowired
	private IDcardServices idService;
	
	@GetMapping("/id")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("HELLO !",HttpStatus.OK);
	}
	
	@PostMapping("/id/save")
	public ResponseEntity<IDCard> registerID(@Valid @RequestBody IDCard id) throws IdCardException{
		IDCard savedId =  idService.addIdCard(id);
		
		return new ResponseEntity<IDCard>(savedId,HttpStatus.ACCEPTED);
	}
	
}
