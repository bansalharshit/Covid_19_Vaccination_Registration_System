package com.masai.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "First Name is mandatory")
	private String firstName;
	
	@NotNull(message = "Last Name is mandatory")
	private String lastName;
	
	@NotNull(message = "Provide Mobile Number ")
	@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$"
			,message ="Provide a Valid Mobile Number !")
	private String mobileNo;
	
	@NotNull(message = "Password is mandatory")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",
	message = "Password must be of 8 characters and must include "
			+ " at least one upper case English letter, one lower case "
			+ "English letter, one number and one special character.")
	private String password;
	
	
	@NotNull(message = "Email is mandatory")
	@Email(message = "Provide a Valid Email !")
	private String email;
	
}