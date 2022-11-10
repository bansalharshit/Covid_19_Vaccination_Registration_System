package com.masai.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) throws UserException{
		return userRepo.save(user);
	}
}
