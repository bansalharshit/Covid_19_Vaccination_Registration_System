package com.masai.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.masai.Model.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberid;	
	
	private Boolean dose1status;
	private Boolean dose2status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate datefor1dose;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate datefor2dose;

	@OneToOne(cascade = CascadeType.ALL)
	private IDCard idCard;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member", fetch = FetchType.EAGER)
	private List<Appointment> appointments = new ArrayList<Appointment>();

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public Boolean getDose1status() {
		return dose1status;
	}

	public void setDose1status(Boolean dose1status) {
		this.dose1status = dose1status;
	}

	public Boolean getDose2status() {
		return dose2status;
	}

	public void setDose2status(Boolean dose2status) {
		this.dose2status = dose2status;
	}

	public LocalDate getDatefor1dose() {
		return datefor1dose;
	}

	public void setDatefor1dose(LocalDate datefor1dose) {
		this.datefor1dose = datefor1dose;
	}

	public LocalDate getDatefor2dose() {
		return datefor2dose;
	}

	public void setDatefor2dose(LocalDate datefor2dose) {
		this.datefor2dose = datefor2dose;
	}

	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public VaccineRegistration getVaccineRegistration() {
		return vaccineRegistration;
	}

	public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
		this.vaccineRegistration = vaccineRegistration;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", dose1status=" + dose1status + ", dose2status=" + dose2status
				+ ", datefor1dose=" + datefor1dose + ", datefor2dose=" + datefor2dose + ", idCard=" + idCard
				+ ", vaccine=" + vaccine + ", vaccineRegistration=" + vaccineRegistration + ", appointments="
				+ appointments + "]";
	}

	public Member(Integer memberid, Boolean dose1status, Boolean dose2status, LocalDate datefor1dose,
			LocalDate datefor2dose, IDCard idCard, Vaccine vaccine, VaccineRegistration vaccineRegistration,
			List<Appointment> appointments) {
		super();
		this.memberid = memberid;
		this.dose1status = dose1status;
		this.dose2status = dose2status;
		this.datefor1dose = datefor1dose;
		this.datefor2dose = datefor2dose;
		this.idCard = idCard;
		this.vaccine = vaccine;
		this.vaccineRegistration = vaccineRegistration;
		this.appointments = appointments;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
