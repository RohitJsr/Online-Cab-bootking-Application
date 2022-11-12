package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exceptions.DriverException;
import com.masai.model.Cab;
import com.masai.model.CabType;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.DriverDTO;
import com.masai.repository.CabDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.DriverDao;
import com.masai.repository.SessionDao;

@Service
public class DriverServiceImpl implements DriverService{

	
	@Autowired
	private DriverDao dDao;
	
	@Autowired
	private CabDao cabDao;
	
	
	@Autowired
	private SessionDao sDao;

	
	@Override
	public Driver createDriver(DriverDTO cabdto)throws DriverException {
		
		Cab cab = new Cab();
		cab.setCabtype(cabdto.getCarType());
		cab.setNumberPlate(cabdto.getNumberPlate());
		cab.setRatePerKms(cabdto.getRatePerKms());
		
		Driver driver = new Driver();
		driver.setAddress(cabdto.getAddress());
		driver.setUsername(cabdto.getUsername());
		driver.setPassword(cabdto.getPassword());
		driver.setMobileNumber(cabdto.getMobileNumber());
		driver.setEmail(cabdto.getEmail());
		driver.setCab(cab);
		driver.setLicenseNumber(cabdto.getLicenseNumber());
		
		cab.setDriver(driver);
		
		Driver existingdriver= dDao.findByMobileNumber(cabdto.getMobileNumber());

		if(existingdriver != null ) 
			throw new DriverException("Driver Already Registered with Mobile number");
		
		Cab cb = cabDao.findByNumberPlate(cab.getNumberPlate());
		if(cb != null) throw new DriverException("Number Plate already registered");
			
	    dDao.save(driver);
	    return driver;
			
			
		}
			
		

	@Override
	public Driver updateDriver(DriverDTO driver, String key) throws DriverException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new DriverException("Please provide a valid key to update a Driver");
		}
		
		
		if(driver.getDriverId() == loggedInUser.getUserId()) {
			
			
			Driver d= dDao.findById(driver.getDriverId()).get();
			Cab cb = d.getCab();
			d.setMobileNumber(driver.getMobileNumber());
			d.setUsername(driver.getUsername());
			d.setPassword(driver.getPassword());
			d.setAddress(driver.getAddress());
			d.setEmail(driver.getEmail());
			cb.setCabtype(driver.getCarType());
			cb.setNumberPlate(driver.getNumberPlate());
			cb.setRatePerKms(driver.getRatePerKms());
			
	    	dDao.save(d);
			
	    	return d;
		
			
		}
		else
			throw new DriverException("Invalid Driver Details, please login first");
	}
	@Override
	public String deleteDriver(DriverDTO driver, String key) throws DriverException {
		
		
	CurrentUserSession loggedInUser= sDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new DriverException("Please provide a valid key to update a Driver");
		}
		
		
		if(driver.getDriverId() == loggedInUser.getUserId()) {
			
			
		// TODO Auto-generated method stub
		
		Driver driverDetails = dDao.findById(driver.getDriverId()).orElseThrow(() -> new DriverException("Driver does not exist with id : "+ driver.getDriverId()));
		dDao.delete(driverDetails);
		return "driver with id : " + driver.getDriverId() + " Deleted" ;
	
	}else {
		throw new DriverException("Wrong Details please login first!");
	}
	}





	
	
	
}
