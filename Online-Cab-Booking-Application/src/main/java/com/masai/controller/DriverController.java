package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.DriverException;
import com.masai.exceptions.TripBookingException;
import com.masai.model.Customer;
import com.masai.model.Driver;
import com.masai.model.DriverDTO;
import com.masai.model.TripBookingDTO;
import com.masai.service.DriverService;
import com.masai.service.TripBookingService;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {
	
	@Autowired
	private DriverService dService;
	
	@Autowired
	private TripBookingService tripBookingService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Driver> saveDriver(@Valid @RequestBody DriverDTO driver) throws DriverException {
		
		Driver savedDriver= dService.createDriver(driver);
		
		
		return new ResponseEntity<Driver>(savedDriver,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public  ResponseEntity<Driver> updateDriver(@Valid @RequestBody DriverDTO driver,@RequestParam(required = false) String key ) throws DriverException {
		
		
		Driver updatedCustomer= dService.updateDriver(driver, key);
				
		return new ResponseEntity<Driver>(updatedCustomer,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteDrive(DriverDTO driver,@RequestParam String key) throws DriverException{
		
		String DeleteDriver = dService.deleteDriver(driver,key);
		
		return new ResponseEntity<String>(DeleteDriver,HttpStatus.OK);
	}
	
	@GetMapping("/tripCompleted")
	public ResponseEntity<String> tripCompletionHandler(@RequestParam Integer driverId,@RequestParam String key) throws TripBookingException{
		String mess = tripBookingService.calculateBill(driverId,key);
		return  new ResponseEntity<String>(mess,HttpStatus.OK);
	}

}
