package com.masai.Services;

import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.User;

@Service
public interface UserServices {
	
	public User createUser(User user) throws UserException;
	
	public User updateUser(User user, String key) throws UserException;

}
