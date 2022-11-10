package com.masai.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.User;
import com.masai.Repository.SessionRepository;
import com.masai.Repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SessionRepository sessionRepo;

	@Override
	public User createUser(User user) throws UserException{
		User existingUser = userRepo.findByEmail(user.getEmail());
		
		if(existingUser != null) {
			throw new UserException("User Already Exist with this Email. Try Loggin !");
		}
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		
		CurrentUserSession loggedInUser =  sessionRepo.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide valid Key to Update User.");
		}
		
		if(user.getUserId() == loggedInUser.getUserId()) {
			return userRepo.save(user);
		}else {
			throw new UserException("Login First !");
		}
	}
}
