package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.VaccinationCenter;



@Repository
public interface VaccineCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

	
}