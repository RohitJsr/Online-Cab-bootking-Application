package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.DriverException;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService dService;
	
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> saveCustomer(@Valid @RequestBody Driver driver) throws DriverException {
		
		Driver savedDriver= dService.createDriver(driver);
		
		
		return new ResponseEntity<Driver>(savedDriver,HttpStatus.CREATED);
	}
	
	@PutMapping("/drivers")
	public  ResponseEntity<Driver> updateCustomer(@Valid @RequestBody Driver driver,@RequestParam(required = false) String key ) throws DriverException {
		
		
		Driver updatedCustomer= dService.updateDriver(driver, key);
				
		return new ResponseEntity<Driver>(updatedCustomer,HttpStatus.OK);
		
	}
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> deleteCustomer(@PathVariable("id") Integer driverId) throws DriverException{
		
		Driver DeleteDriver = dService.deleteDriver(driverId);
		
		return new ResponseEntity<Driver>(DeleteDriver,HttpStatus.OK);
	}
	

}
