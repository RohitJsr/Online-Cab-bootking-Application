package com.masai.service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.DriverException;
import com.masai.model.Admin;
import com.masai.model.Driver;

public interface AdminService {

	 public Admin createAdmin(Admin Admin)throws AdminException;
		
	 public  Admin updateAdmin(Admin Admin,String key)throws AdminException;

	
}
