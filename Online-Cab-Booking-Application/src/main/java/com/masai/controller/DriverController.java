package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.masai.exceptions.DriverException;
import com.masai.model.Driver;
import com.masai.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService dService;
	
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> saveDrivers(@Valid @RequestBody Driver driver) throws DriverException {
		
		Driver savedDriver= dService.createDriver(driver);
		
		
		return new ResponseEntity<Driver>(savedDriver,HttpStatus.CREATED);
	}
	
	@PutMapping("/drivers")
	public  ResponseEntity<Driver> updateDrivers(@RequestBody Driver driver,@RequestParam(required = false) String key ) throws DriverException {
		
		
		Driver updatedCustomer= dService.updateDriver(driver, key);
				
		return new ResponseEntity<Driver>(updatedCustomer,HttpStatus.OK);
		
	}
	
	

}
