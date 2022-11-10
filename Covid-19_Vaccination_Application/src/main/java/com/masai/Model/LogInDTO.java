package com.masai.Model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LogInDTO {
	
	@NotEmpty(message = "Enter Valid Mobile Number")
	private String mobileNo;
	
	@NotEmpty(message = "Enter Correct Password !")
	private String password;

}
