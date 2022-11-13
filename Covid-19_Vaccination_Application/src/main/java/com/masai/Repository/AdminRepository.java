package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Admin;
import com.masai.Model.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByMobileNo(String mobileNo);
	
}
