package com.masai.service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.DriverException;
import com.masai.model.Customer;
import com.masai.model.Driver;

public interface DriverService {
	
     public Driver createDriver(Driver Driver)throws DriverException;
	
	public  Driver updateDriver(Driver Driver,String key)throws DriverException;
	
	public Driver deleteDriver(int driverId) throws DriverException;



}
