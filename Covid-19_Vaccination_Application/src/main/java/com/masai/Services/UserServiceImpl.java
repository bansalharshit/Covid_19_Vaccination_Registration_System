package com.masai.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.User;
import com.masai.Model.UserDto;
import com.masai.Repository.UserRepository;
import com.masai.Repository.UserSessionRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserSessionRepository sessionRepo;
	//usersession is remaining --> mainly needed for update and delete
	//autowire it here

	@Override
	public User createNewUser(User user) throws UserException {
		//signUp functionality
		
		User newUserByMobile = userRepo.findByMobileNo(user.getMobileNo());
		
		if(newUserByMobile != null) {
			throw new UserException("User Already Exists With This Mobile/Email ! Please Login.");
		}
		
		return userRepo.save(user);
		
	}

	@Override
	public User updateUser(User user, String password) throws UserException {
		
		
		Optional<User> existedUserOpt = userRepo.findById(user.getId());
		
		
		Optional<CurrentUserSession> currUserOpt = sessionRepo.findByUserId(user.getId());
		
		if(currUserOpt.isPresent()) {
			throw new UserException("User Is Already Logged In");
		}
		
		if(existedUserOpt.isPresent()) {
			User savingUser  = existedUserOpt.get();
			System.out.println(savingUser.getPassword()+" "+password );
			if(savingUser.getPassword().equals(password)) {
				return userRepo.save(user);
			}else {
				throw new UserException("Password Did Not Matched !");
			}
		}else {
			throw new UserException("User Not Found !");
		}
	}

	@Override
	public User removeUser(UserDto userDto) throws UserException{
		
		User existedUser = userRepo.findByMobileNo(userDto.getMobileNo());
		
		if(existedUser != null) {
			if(existedUser.getPassword().equals(userDto.getPassword())) {
				userRepo.delete(existedUser);
				return existedUser;
			}else {
				throw new UserException("Password Did Not Matched !");
			}
		}else {
			throw new UserException("User Not Found !");
		}
	}
	

	

}
