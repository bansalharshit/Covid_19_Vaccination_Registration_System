package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Appointment;
import com.masai.Model.Member;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

	List<Appointment> findByMember(Member member);
	
}
