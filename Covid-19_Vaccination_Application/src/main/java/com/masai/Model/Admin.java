package com.masai.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Admin {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@NotNull(message = "Name is mandatory!")
	
	private String name;
	
	@Column(unique = true)
	@Size(max = 10,min = 9)
	@NotNull(message = "Mobile number is mandatory!")
	private String mobileNo;
	
	@NotNull(message = "Password cannot be null!")
	private String password;
	
	@Email(message = "Not a valid email Id, please check again..")
	@NotNull(message = "Email Id is mandatory")
	private String email;


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Admin(Integer id, String name, String mobileNo, String password, String email) {
		super();
		Id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.email = email;
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
