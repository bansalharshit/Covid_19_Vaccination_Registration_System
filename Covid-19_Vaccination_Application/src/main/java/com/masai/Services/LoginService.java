package com.masai.Services;

import com.masai.Exception.LoginException;
import com.masai.Model.LogInDTO;

public interface LoginService {
	
	public String logInToAccount(LogInDTO dto) throws LoginException;
	
	public String logOutFromAccount(String key) throws LoginException;

}
