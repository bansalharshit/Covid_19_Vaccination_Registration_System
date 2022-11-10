package com.masai.Model;

public class Address {
	
	private String locality;
	private String state;
	private String city;
	private String pinCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Address(String locality, String state, String city, String pinCode) {
		super();
		this.locality = locality;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
	}



	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [locality=" + locality + ", state=" + state + ", city=" + city + ", pinCode=" + pinCode + "]";
	}
	
	
	

}
