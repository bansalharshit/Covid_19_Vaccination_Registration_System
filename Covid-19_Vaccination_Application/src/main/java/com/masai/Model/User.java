package com.masai.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotNull(message = "First Name Cannot Be Null !")
	private String firstName;
	
	@NotNull(message = "Last Name Cannot Be Null !")
	private String lastName;
	
	
	
	@Email(message = "Enter Correct Email")
	private String email;
	
	@Size(min = 8 , max = 16, message = "Enter Password in Valid Range.")
	private String password;
}
