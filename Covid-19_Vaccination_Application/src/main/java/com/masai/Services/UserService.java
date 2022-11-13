package com.masai.Services;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Model.UserDto;

public interface UserService {
	
	public User createNewUser(User user) throws UserException;
	
	public User updateUser(User user,String password) throws UserException;
	
	public User removeUser(UserDto usrDto) throws UserException;

}
