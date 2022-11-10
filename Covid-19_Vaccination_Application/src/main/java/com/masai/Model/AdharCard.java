package com.masai.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Digits;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AdharCard {
	
	
	@Digits(integer = 12,fraction = 12, message = "aadhar Id must be 12 digits")
	private long adharNo;

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public AdharCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdharCard(long adharNo) {
		super();
		this.adharNo = adharNo;
	}
	
	

}
