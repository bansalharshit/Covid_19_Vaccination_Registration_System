package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.VaccineInventory;

@Repository
public interface VaccineInventoryReposistory extends JpaRepository<VaccineInventory, Integer>{

	public List<VaccineInventory> findByDate(LocalDate date);
	
}
