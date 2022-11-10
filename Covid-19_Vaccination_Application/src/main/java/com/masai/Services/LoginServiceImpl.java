package com.masai.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.LoginException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.LogInDTO;
import com.masai.Model.User;
import com.masai.Repository.SessionRepository;
import com.masai.Repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private SessionRepository sRepo;
	

	@Override
	public String logInToAccount(LogInDTO dto) throws LoginException {
		User existingUser = uRepo.findByEmail(dto.getEmail());
		
		if(existingUser == null) {
			throw new LoginException("Please Enter A valid Mobile Number.");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =  sRepo.findById(existingUser.getUserId());
		
		if(validUserSessionOpt.isPresent()){
			throw new LoginException("User already Logged In with this number");
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			
			CurrentUserSession currentUserSession = 
					new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			
			sRepo.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sRepo.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}

}
