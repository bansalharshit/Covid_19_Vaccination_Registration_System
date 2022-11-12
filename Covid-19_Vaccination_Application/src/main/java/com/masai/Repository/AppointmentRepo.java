package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

}
