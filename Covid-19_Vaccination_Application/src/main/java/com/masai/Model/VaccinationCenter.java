package com.masai.Model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.Model.Appointment;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
@Entity
public class VaccinationCenter {

	
	@Id
	private Integer code;

	@NotNull(message = "Center name can not be null")
	@NotBlank(message = "Center name is Mandatory")
	private String centreName;

	@NotNull(message = "City can not be null")
	@NotBlank(message = "City name is Mandatory")
	private String city;

	@NotNull(message = "Address can not be null")
	@NotBlank(message = "Address is Mandatory")
	private String Address;

	@NotNull(message = "State can not be null")
	@NotBlank(message = "State name is Mandatory")
	private String state;

	@NotNull(message = "Pincode can not be null")
	@NotBlank(message = "Pincode is Mandatory")
	@Size(min = 6, max = 8)
	private String pincode;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccinationCenter")
	private List<Appointment> appointments;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccineInventory vaccineInventory;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public VaccineInventory getVaccineInventory() {
		return vaccineInventory;
	}

	public void setVaccineInventory(VaccineInventory vaccineInventory) {
		this.vaccineInventory = vaccineInventory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, appointments, centreName, city, code, pincode, state, vaccineInventory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccinationCenter other = (VaccinationCenter) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(appointments, other.appointments)
				&& Objects.equals(centreName, other.centreName) && Objects.equals(city, other.city)
				&& Objects.equals(code, other.code) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(state, other.state) && Objects.equals(vaccineInventory, other.vaccineInventory);
	}

	public VaccinationCenter(Integer code, String centreName, String address, String city, String state, String pincode,
			List<Appointment> appointments, VaccineInventory vaccineInventory) {
		super();
		this.code = code;
		this.centreName = centreName;
		Address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.appointments = appointments;
		this.vaccineInventory = vaccineInventory;
	}

	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
