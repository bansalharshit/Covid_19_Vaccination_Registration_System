package com.masai.Services;

import com.masai.Exception.LoginException;
import com.masai.Model.AdminDto;
import com.masai.Model.UserDto;

public interface LoginServices {
	
	public String logInToUserAccount(UserDto udto) throws LoginException;
	
	public String logOutFromUserAccount(String key) throws LoginException;
	
	public String logInToAdminAccount(AdminDto adto) throws LoginException;
	
	public String logOutFromAdminAccount(String key) throws LoginException;

}
