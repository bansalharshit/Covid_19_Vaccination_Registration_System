package com.masai.Model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Pancard {
	
  
	@Size(max=10,message="Pan card number length is maximum 10!")
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Pan Card Number is Invalid!")
	private String panNo;
	
public String getPanNo() {
	return panNo;
}

public void setPanNo(String panNo) {
	this.panNo = panNo;
}

public Pancard(String panNo) {
	super();
	this.panNo = panNo;
}

public Pancard() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
 

}
