package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exceptions.DriverException;
import com.masai.model.Cab;
import com.masai.model.CabType;
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
	

	
	@Override
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
	public Driver deleteDriver(Driver driver) throws DriverException {
		// TODO Auto-generated method stub
		
		Driver driverDetails = dDao.findById(driver.getDriverId()).orElseThrow(() -> new DriverException("Driver does not exist with id : "+ driver.getDriverId()));
		dDao.delete(driverDetails);
		return driver;
	
	}

	@Override
	public List<Driver> viewDriver() throws DriverException {
		// TODO Auto-generated method stub
		
		List<Driver> list = dDao.findAll();
		
		if(list == null)
			throw new DriverException("No Driver found");
		
		return list;
		
		
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverException {
		// TODO Auto-generated method stub
	
		return dDao.findById(driverId).orElseThrow(() -> new DriverException("Driver doesn't exist with id :"+ driverId));
	}
	
	
}
