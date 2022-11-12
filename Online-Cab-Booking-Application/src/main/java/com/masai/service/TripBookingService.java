package com.masai.service;

import java.util.List;

import com.masai.exceptions.TripBookingException;
import com.masai.model.BillDetails;
import com.masai.model.TripBooking;
import com.masai.model.TripBookingDTO;

public interface TripBookingService {

	public TripBooking insertTripBooking(TripBookingDTO tripBooking)throws TripBookingException;

	public String deleteTripBooking(Integer customerId) throws TripBookingException;
	
	public List<TripBooking> viewAllTripsCustomer(int customerld) throws TripBookingException;
	
	public String calculateBill(Integer DriverId) throws TripBookingException;
	
	public BillDetails generateBill(Integer customerId, Integer tripBookingId) throws TripBookingException;
	
	public List<TripBooking> getAllTrips() throws TripBookingException;

}
