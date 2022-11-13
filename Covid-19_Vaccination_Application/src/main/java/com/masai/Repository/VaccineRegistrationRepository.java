package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.VaccineRegistration;

public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, String>{

}
