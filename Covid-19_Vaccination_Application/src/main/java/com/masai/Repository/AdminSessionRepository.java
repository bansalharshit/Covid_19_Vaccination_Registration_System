package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.CurrentAdminSession;

public interface AdminSessionRepository extends JpaRepository<CurrentAdminSession, Integer> {

	public Optional<CurrentAdminSession> findByUuid(String uuid);
	
	public Optional<CurrentAdminSession> findByAdminId(Integer adminId); 
}
