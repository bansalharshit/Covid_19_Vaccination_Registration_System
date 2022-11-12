package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
	
	public Optional<Vaccine> findByvaccinename(String name);

}
