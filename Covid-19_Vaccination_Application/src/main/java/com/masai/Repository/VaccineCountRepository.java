package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Vaccine;
import com.masai.Model.VaccineCount;

public interface VaccineCountRepository extends JpaRepository<VaccineCount, Integer> {

	
	VaccineCount findByvaccine(Vaccine vaccine);

	VaccineCount findByvaccineId(Integer vaccineid);
}
