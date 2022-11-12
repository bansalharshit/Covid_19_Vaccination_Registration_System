package com.masai.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
@Entity
public class VaccineInventory {
	
	@Id
	private Integer vaccineInventoryId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message = "Date should not be Null")
	private LocalDate date;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineInventory")
    private List<VaccinationCenter> vaccinationCanter;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineInventory")
	private List<VaccineCount> vaccinecount=new ArrayList<>();

	public Integer getVaccineInventoryId() {
		return vaccineInventoryId;
	}

	public void setVaccineInventoryId(Integer vaccineInventoryId) {
		this.vaccineInventoryId = vaccineInventoryId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<VaccinationCenter> getVaccinationCanter() {
		return vaccinationCanter;
	}

	public void setVaccinationCanter(List<VaccinationCenter> vaccinationCanter) {
		this.vaccinationCanter = vaccinationCanter;
	}

	public List<VaccineCount> getVaccinecount() {
		return vaccinecount;
	}

	public void setVaccinecount(List<VaccineCount> vaccinecount) {
		this.vaccinecount = vaccinecount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, vaccinationCanter, vaccineInventoryId, vaccinecount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccineInventory other = (VaccineInventory) obj;
		return Objects.equals(date, other.date) && Objects.equals(vaccinationCanter, other.vaccinationCanter)
				&& Objects.equals(vaccineInventoryId, other.vaccineInventoryId)
				&& Objects.equals(vaccinecount, other.vaccinecount);
	}

	public VaccineInventory(Integer vaccineInventoryId, LocalDate date, List<VaccinationCenter> vaccinationCanter,
			List<VaccineCount> vaccinecount) {
		super();
		this.vaccineInventoryId = vaccineInventoryId;
		this.date = date;
		this.vaccinationCanter = vaccinationCanter;
		this.vaccinecount = vaccinecount;
	}

	public VaccineInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
