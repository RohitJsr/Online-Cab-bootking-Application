package com.masai.controller;

import java.util.List;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;

import com.masai.model.Admin;

import com.masai.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService AService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) throws AdminException {
		
		Admin savedAdmin = AService.createAdmin(admin);
		
		
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public  ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin,@RequestParam(required = false) String key ) throws AdminException {
		
		
		Admin updatedCustomer= AService.updateAdmin(admin, key);
				
		return new ResponseEntity<Admin>(updatedCustomer,HttpStatus.OK);
		
	}
	@DeleteMapping("/detete")
	public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) throws AdminException{
		
		Admin DeleteAdmin = AService.deleteAdmin(admin);
		
		return new ResponseEntity<Admin>(DeleteAdmin,HttpStatus.OK);
	}
	

	@GetMapping("/tripbookings/{customerId}")
	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable("customerId") Integer customerId) throws TripBookingException{
		
		List<TripBooking> listOfBooking=AService.getAllTrips(customerId);
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}
	
	@GetMapping("/tripbookings")
	public ResponseEntity<List<Driver>> getAllTripsDriverWise() throws DriverException{
		
		List<Driver> listOfBooking=AService.getTripsDriver();
		return new ResponseEntity<List<Driver>>(listOfBooking,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/tripbookingsCustomerWise")
	public ResponseEntity<List<Customer>> getAllTripsCustomerWise() throws CustomerException{
		
		List<Customer> listOfBooking=AService.getTripsCustomerwise();
		return new ResponseEntity<List<Customer>>(listOfBooking,HttpStatus.OK);
		
	}

	
	@GetMapping("/tripbookingsDateWise")
	public ResponseEntity<List<TripBooking>> getAllTripDateWise() throws TripBookingException{
		
		List<TripBooking> listOfBooking=AService.getTripsDatewise();
		return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	}
	

	// @GetMapping("/tripbookings{customerId}/{fromDate}/{toDate}")
	// public ResponseEntity<List<TripBooking>> getAllTripsbetwwenDays(@PathVariable("customerId")Integer customerId,@PathVariable("fromDate")LocalDateTime fromDate, @PathVariable("toDate")LocalDateTime toDate) throws TripBookingException{
		
	// 	List<TripBooking> listOfBooking=AService.getAllTripDateWise(customerId, fromDate, toDate);
	// 	return new ResponseEntity<List<TripBooking>>(listOfBooking,HttpStatus.OK);
		
	// }

	
	

}
