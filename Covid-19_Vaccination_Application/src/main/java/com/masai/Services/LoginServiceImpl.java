package com.masai.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.LoginException;
import com.masai.Model.Admin;
import com.masai.Model.AdminDto;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.User;
import com.masai.Model.UserDto;
import com.masai.Repository.AdminRepository;
import com.masai.Repository.AdminSessionRepository;
import com.masai.Repository.UserRepository;
import com.masai.Repository.UserSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginServices{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserSessionRepository userSession;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private AdminSessionRepository adminSession;

	@Override
	public String logInToUserAccount(UserDto udto) throws LoginException {
		
		User existingUser = userRepo.findByMobileNo(udto.getMobileNo());
		
		if(existingUser == null) {
			throw new LoginException("No User Found with this Mobile Number !");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt = userSession.findByUserId(existingUser.getId());
		
//		System.out.println(validUserSessionOpt.get());
		
		if(validUserSessionOpt.isPresent()) {
			throw new LoginException("User Already logged In with this Number !");
		}
		
		if(existingUser.getPassword().equals(udto.getPassword())) {
			
			
			String key = RandomString.make(6);
			
			CurrentUserSession cus =  
					new CurrentUserSession(existingUser.getId(), key,LocalDateTime.now());
			
			userSession.save(cus);
			
			return cus.toString();
			
			
		}else {
			throw new LoginException("Please Enter a valid password");
		}
		
	}

	@Override
	public String logOutFromUserAccount(String key) throws LoginException {
		
		Optional<CurrentUserSession> validUserSession =  userSession.findByUuid(key);
		
		if(validUserSession.isPresent()) {
			CurrentUserSession cus=(validUserSession.get());
					userSession.delete(cus);
			return cus.getUserId()+" User Logged Out Successfully !";
			
		}
		
		throw new LoginException("User Not Logged In with this number");
	}

	@Override
	public String logInToAdminAccount(AdminDto adto) throws LoginException {

		Admin existingAdmin = 	adminRepo.findByMobileNo(adto.getMobileNo());
		
		Optional<CurrentAdminSession> validAdminSessionOpt = adminSession.findByAdminId(existingAdmin.getId());
		
		if(existingAdmin == null || !existingAdmin.getPassword().equals(adto.getPassword())) {
			throw new LoginException("No Admin Found with this Mobile Number or password is incorrect... !");
		}
		
	
		if(validAdminSessionOpt.isPresent()) {
			throw new LoginException("Admin is Already logged In with this Number !");
		}
		
		if(existingAdmin.getPassword().equals(adto.getPassword())) {
			
			
			String key = RandomString.make(6);
			
			CurrentAdminSession cas =  
					new CurrentAdminSession(existingAdmin.getId(), key,LocalDateTime.now());
			
			adminSession.save(cas);
			
			return cas.toString();
			
			
		}else {
			throw new LoginException("Please Enter a valid password");
		}
		
	}

	@Override
	public String logOutFromAdminAccount(String key) throws LoginException {
		
		Optional<CurrentAdminSession> validAdminSession =  adminSession.findByUuid(key);
		
		if(validAdminSession.isPresent()) {
			CurrentAdminSession cas=validAdminSession.get();
					adminSession.delete(cas);
			return cas.getAdminId()+" Admin Logged Out Successfully !";
		}
		
		throw new LoginException("Admin Not Logged In with this UUID");
	}

}
