package com.masai.Model;

import javax.validation.constraints.NotNull;

import lombok.Data;

//@Data
public class AdminDto {
	
	@NotNull(message = "Mobile number is mandatory")
	private String mobileNo;
	
	
	@NotNull(message = "Password is mandatory")
	private String password;



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
	
	
	
}
