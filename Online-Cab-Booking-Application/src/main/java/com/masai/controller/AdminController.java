package com.masai.controller;

import java.util.List;

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

import com.masai.exceptions.AdminException;
import com.masai.exceptions.TripBookingException;
import com.masai.model.Admin;
import com.masai.model.TripBooking;
import com.masai.service.AdminService;
import com.masai.service.TripBookingService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService AService;
	
	@Autowired
	private TripBookingService tripBookingService;
	
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
	public ResponseEntity<String> deleteAdmin(@RequestParam Integer adminId, @RequestParam String key) throws AdminException{
		
		String DeleteAdmin = AService.deleteAdmin(adminId, key);
		
		return new ResponseEntity<String>(DeleteAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/Alltrips")
	public ResponseEntity<List<TripBooking>>  allTrips(@RequestParam Integer adminId ,@RequestParam String key) throws TripBookingException{
		
		List<TripBooking> tripBooking = tripBookingService.getAllTrips(adminId,key);
		
		return new ResponseEntity<List<TripBooking>>(tripBooking,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTripsByCab")
	public ResponseEntity<List<TripBooking>> getAllTripsByCab(@RequestParam Integer cabId,@RequestParam Integer adminId,@RequestParam String key) throws AdminException{
		
		List<TripBooking> tripBooking = AService.getAllTripsByCab(cabId,adminId,key);
		
		return new ResponseEntity<List<TripBooking>>(tripBooking,HttpStatus.OK);
		
	}
	

}
