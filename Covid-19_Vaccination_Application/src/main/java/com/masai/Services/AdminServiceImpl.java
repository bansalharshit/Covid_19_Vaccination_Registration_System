package com.masai.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.Admin;
import com.masai.Model.AdminDto;
import com.masai.Model.CurrentAdminSession;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.User;
import com.masai.Repository.AdminRepository;
import com.masai.Repository.AdminSessionRepository;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private AdminSessionRepository adminSession;
	
	@Override
	public Admin createNewAdmin(Admin admin) throws UserException {
		
		Admin newAdminByMobile = adminRepo.findByMobileNo(admin.getMobileNo());
		
		if(newAdminByMobile!= null) {
			throw new UserException("Admin is Already Exists With This Mobile/Email ! Please Login.");
		}
		
		return adminRepo.save(admin);	
	}

	@Override
	public Admin updateAdmin(Admin admin, String password) throws UserException {
		//User password will be checked first
				//if password is correct update details else throw error
				
				Optional<Admin> existedAdminOpt = adminRepo.findById(admin.getId());
				
				//checking whether he is currently login or not
				Optional<CurrentAdminSession> currAdminOpt = adminSession.findByAdminId(admin.getId());
				
				if(currAdminOpt.isPresent()) {
					throw new UserException("ADMIN Is Already Logged In");
				}
				
				if(existedAdminOpt.isPresent()) {
					Admin savingAdmin  = existedAdminOpt.get();
					System.out.println(savingAdmin.getPassword()+" "+password );
					if(savingAdmin.getPassword().equals(password)) {
						return adminRepo.save(admin);
					}else {
						throw new UserException("Password Did Not Matched !");
					}
				}else {
					throw new UserException("Admin Not Found !");
				}
	}

	@Override
	public Admin removeAdmin(AdminDto adminDto) throws UserException {
		
		Admin existedAdmin = adminRepo.findByMobileNo(adminDto.getMobileNo());
		
		if(existedAdmin != null) {
			if(existedAdmin.getPassword().equals(adminDto.getPassword())) {
				adminRepo.delete(existedAdmin);
				return existedAdmin;
			}else {
				throw new UserException("Password Did Not Matched !");
			}
		}else {
			throw new UserException("Admin Not Found !");
		}
	}

}
