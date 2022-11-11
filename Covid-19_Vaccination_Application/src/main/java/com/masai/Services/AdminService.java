package com.masai.Services;

import com.masai.Exception.UserException;
import com.masai.Model.Admin;
import com.masai.Model.AdminDto;

public interface AdminService {
	
	public Admin createNewAdmin(Admin admin) throws UserException;
	
	public Admin updateAdmin(Admin admin,String password) throws UserException;
	
	public Admin removeAdmin(AdminDto adminDto) throws UserException;

}
