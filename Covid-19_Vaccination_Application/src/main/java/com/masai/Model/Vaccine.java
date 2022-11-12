package com.masai.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	@NotNull(message = "Vaccine Name Should not be Null!")
	private String vaccinename;
	private String description;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "vaccine")
	private VaccineCount vaccinecount;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccine")
	private List<Member> member;

	public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccinename() {
		return vaccinename;
	}

	public void setVaccinename(String vaccinename) {
		this.vaccinename = vaccinename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VaccineCount getVaccinecount() {
		return vaccinecount;
	}

	public void setVaccinecount(VaccineCount vaccinecount) {
		this.vaccinecount = vaccinecount;
	}

	public List<Member> getMember() {
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", vaccinename=" + vaccinename + ", description=" + description
				+ ", vaccinecount=" + vaccinecount + ", member=" + member + "]";
	}

	public Vaccine(Integer vaccineId, String vaccinename, String description, VaccineCount vaccinecount,
			List<Member> member) {
		super();
		this.vaccineId = vaccineId;
		this.vaccinename = vaccinename;
		this.description = description;
		this.vaccinecount = vaccinecount;
		this.member = member;
	}

	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
