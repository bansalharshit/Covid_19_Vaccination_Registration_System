package com.masai.Model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class IDCard { 
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	
	@NotNull(message = "Member name can not be null")
	@NotBlank(message = "Member name is Mandatory")
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate Dob;

	@NotNull(message = "Gender can not be null")
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String gender;
	
	@NotNull(message = "Address can not be null")
	private String address;
	
	@NotNull(message = "City can not be null")
	private String city;
	
	@NotNull(message = "State may not be null")
	private String state;
	
	@NotNull(message = "Pincode may not be null")
	@Size(min = 6, max = 8)
	private String pincode;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idCard")
	private Member member;

//	@OneToOne(mappedBy = "idcard")
	@Embedded
	AdharCard adharcard;

//	@OneToOne(mappedBy = "idcard")
	@Embedded
	Pancard pancard;

	public IDCard save(IDCard idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public AdharCard getAdharcard() {
		return adharcard;
	}

	public void setAdharcard(AdharCard adharcard) {
		this.adharcard = adharcard;
	}

	public Pancard getPancard() {
		return pancard;
	}

	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

	public IDCard(Integer id, String name, LocalDate dob, String address, String gender, String city, String state,
			String pincode, Member member, AdharCard adharcard, Pancard pancard) {
		super();
		this.id = id;
		this.name = name;
		Dob = dob;
		this.address = address;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.member = member;
		this.adharcard = adharcard;
		this.pancard = pancard;
	}

	public IDCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
