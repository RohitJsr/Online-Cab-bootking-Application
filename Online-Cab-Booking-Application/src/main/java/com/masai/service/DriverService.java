package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.DriverException;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.DriverDTO;

public interface DriverService {
	
     public Driver createDriver(DriverDTO Driver)throws DriverException;
	
	public  Driver updateDriver(DriverDTO Driver,String key)throws DriverException;
	
	public String deleteDriver(DriverDTO driver ,String key) throws DriverException;
	



}
