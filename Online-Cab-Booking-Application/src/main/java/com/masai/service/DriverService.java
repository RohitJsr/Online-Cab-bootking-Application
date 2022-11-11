package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.DriverException;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.DriverDTO;

public interface DriverService {
	
     public Driver createDriver(DriverDTO Driver)throws DriverException;
	
	public  Driver updateDriver(Driver Driver,String key)throws DriverException;
	
	public Driver deleteDriver(Driver driver) throws DriverException;
	



}
