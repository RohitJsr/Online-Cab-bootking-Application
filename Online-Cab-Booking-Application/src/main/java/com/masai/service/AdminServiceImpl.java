package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.DriverException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.repository.AdminDao;
import com.masai.repository.SessionDao;

@Service
public class AdminServiceImpl implements AdminService {
	

	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private SessionDao sDao;
	

	
	public Admin createAdmin(Admin admin)throws AdminException {
		
		
		Admin existingAdmin= aDao.findByMobileNumber(admin.getMobileNumber());
		
	
		
		
		if(existingAdmin != null ) 
			throw new AdminException("Admin Already Registered with Mobile number");
			
		
		
		
			return aDao.save(admin);
			
			
		}

	@Override
	public Admin updateAdmin(Admin Admin, String key) throws AdminException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new AdminException("Please provide a valid key to update a Admin");
		}
		
		
		if(Admin.getAdminId() == loggedInUser.getUserId()) {
		
			return aDao.save(Admin);
		}
		else
			throw new AdminException("Invalid Admin Details, please login first");
		
		
	
	}
	

	

}
