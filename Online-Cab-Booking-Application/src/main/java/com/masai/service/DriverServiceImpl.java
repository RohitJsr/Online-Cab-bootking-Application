package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exceptions.DriverException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.repository.CustomerDao;
import com.masai.repository.DriverDao;
import com.masai.repository.SessionDao;

@Service
public class DriverServiceImpl implements DriverService{

	
	@Autowired
	private DriverDao dDao;
	
	@Autowired
	private SessionDao sDao;
	
	@Autowired
	private CustomerDao cDao;
	
	public Driver createDriver(Driver driver)throws DriverException {
		
		
		Driver existingdriver= dDao.findByMobileNumber(driver.getMobileNumber());
		
		
		
		
		if(existingdriver != null ) 
			throw new DriverException("Driver Already Registered with Mobile number");
			
		
		
		
			return dDao.save(driver);
			
			
		}

	@Override
	public Driver updateDriver(Driver driver, String key) throws DriverException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new DriverException("Please provide a valid key to update a Driver");
		}
		
		
		if(driver.getDriverId() == loggedInUser.getUserId()) {
		
			return dDao.save(driver);
		}
		else
			throw new DriverException("Invalid Driver Details, please login first");
		
		
	
	}

	@Override
	public Driver deleteDriver(int driverId) throws DriverException {
		// TODO Auto-generated method stub
		
		Driver driver = dDao.findByDriverId(driverId);
		
		if(driver != null) {
			
		 dDao.delete(driver);
		 return driver;
		 
		}
		else {
			
			throw new DriverException("Driver not found with id: "+driverId);
			
		}
		
		
	
	}

	
}
