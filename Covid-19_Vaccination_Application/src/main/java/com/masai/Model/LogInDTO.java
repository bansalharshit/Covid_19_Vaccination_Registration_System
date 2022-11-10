package com.masai.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LogInDTO {
	
	@NotEmpty(message = "Enter Valid Email")
	@Email
	private String email;
	
	@NotNull(message = "You Must Enter Password !")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$",message = "Password must be of 8 characters and must include at least one upper case letter, one lower case letter, and one numeric digit.")
	private String password;

}
