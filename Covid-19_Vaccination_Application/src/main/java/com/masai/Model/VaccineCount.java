package com.masai.Model;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
public class VaccineCount {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer vaccineCountId;	

private Integer vaccineId;
private Integer quantity;
private Double price;
@OneToOne(cascade = CascadeType.ALL)
private Vaccine vaccine;

@JsonIgnore
@ManyToOne(cascade = CascadeType.ALL)
private VaccineInventory vaccineInventory;

public Integer getVaccineCountId() {
	return vaccineCountId;
}

public void setVaccineCountId(Integer vaccineCountId) {
	this.vaccineCountId = vaccineCountId;
}

public Integer getVaccineId() {
	return vaccineId;
}

public void setVaccineId(Integer vaccineId) {
	this.vaccineId = vaccineId;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Vaccine getVaccine() {
	return vaccine;
}

public void setVaccine(Vaccine vaccine) {
	this.vaccine = vaccine;
}

public VaccineInventory getVaccineInventory() {
	return vaccineInventory;
}

public void setVaccineInventory(VaccineInventory vaccineInventory) {
	this.vaccineInventory = vaccineInventory;
}

public VaccineCount(Integer vaccineCountId, Integer vaccineId, Integer quantity, Double price, Vaccine vaccine,
		VaccineInventory vaccineInventory) {
	super();
	this.vaccineCountId = vaccineCountId;
	this.vaccineId = vaccineId;
	this.quantity = quantity;
	this.price = price;
	this.vaccine = vaccine;
	this.vaccineInventory = vaccineInventory;
}

public VaccineCount() {
	super();
	// TODO Auto-generated constructor stub
}




}
