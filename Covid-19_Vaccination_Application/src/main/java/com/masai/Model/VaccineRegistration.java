package com.masai.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class VaccineRegistration {
    
	@Id
	@Size(max=10,message="Moblie Number length should be 10!")
	@Pattern(regexp = "^[6-9][0-9]{9}$",message="Mobile No is Invalid!")
	private String mobileNo;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
//	@NotNull(message = "Date of Registration should not be Null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofregistration;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineRegistration")
	private List<Member> members;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public VaccineRegistration(String mobileNo, LocalDate dateofregistration, List<Member> members) {
		super();
		this.mobileNo = mobileNo;
		this.dateofregistration = dateofregistration;
		this.members = members;
	}

	public VaccineRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
