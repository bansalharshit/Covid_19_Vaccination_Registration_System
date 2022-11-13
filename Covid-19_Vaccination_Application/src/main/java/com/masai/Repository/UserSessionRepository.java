package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.CurrentUserSession;

@Repository
public interface UserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	public Optional<CurrentUserSession> findByUuid(String uuid);
	
	public Optional<CurrentUserSession> findByUserId(Integer userId); 
}
