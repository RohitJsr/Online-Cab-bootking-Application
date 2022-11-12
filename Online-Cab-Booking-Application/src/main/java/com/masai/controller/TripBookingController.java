package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.TripBookingException;
import com.masai.model.BillDetails;
import com.masai.model.TripBooking;
import com.masai.model.TripBookingDTO;
import com.masai.service.TripBookingService;

@RestController
public class TripBookingController {
	
	@Autowired
	 public TripBookingService tripBookingService;
	
	@PostMapping("/tripbooking")
	public ResponseEntity<TripBooking> registerTripBooking(@RequestBody TripBookingDTO tripBooking) throws TripBookingException{
		
		TripBooking savedBooking=tripBookingService.insertTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(savedBooking,HttpStatus.OK);	
		
	}
	
	
	@DeleteMapping("/canceltrip")
	public ResponseEntity<String> deleteTripBooking(@RequestBody TripBookingDTO tripBooking ) throws TripBookingException{
		
	   String  deleteBooking=tripBookingService.deleteTripBooking(tripBooking);		
		return new ResponseEntity<String>(deleteBooking,HttpStatus.OK);	
	
	}
	
	@GetMapping("/tripbooking/{customerid}")
	public ResponseEntity<List<TripBooking>> allTripBooking(@PathVariable("customerid") Integer customerId) throws TripBookingException{
		
		List<TripBooking> savedBooking=tripBookingService.viewAllTripsCustomer(customerId);		
		return new ResponseEntity<List<TripBooking>>(savedBooking,HttpStatus.OK);	
	
	}
	
	@GetMapping("/Alltrips")
	public ResponseEntity<List<TripBooking>>  allTrips() throws TripBookingException{
		
		List<TripBooking> tripBooking = tripBookingService.getAllTrips();
		
		return new ResponseEntity<List<TripBooking>>(tripBooking,HttpStatus.OK);
	}
	
	


}
