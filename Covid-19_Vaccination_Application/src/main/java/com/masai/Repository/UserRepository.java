package com.masai.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Integer>{
	
	public User findByMobileNo(String mobileNo);
	
//	public User findByEmail(String email);

}
