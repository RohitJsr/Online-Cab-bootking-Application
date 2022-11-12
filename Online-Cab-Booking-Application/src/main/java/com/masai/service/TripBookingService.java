package com.masai.service;

import java.util.List;

import com.masai.exceptions.TripBookingException;
import com.masai.model.BillDetails;
import com.masai.model.TripBooking;
import com.masai.model.TripBookingDTO;

public interface TripBookingService {

	public TripBooking insertTripBooking(TripBookingDTO tripBooking,String key)throws TripBookingException;

	public String deleteTripBooking(Integer customerId,String key) throws TripBookingException;
	
	public List<TripBooking> viewAllTripsCustomer(int customerld,String key) throws TripBookingException;
	
	public String calculateBill(Integer DriverId,String key) throws TripBookingException;
	
	public BillDetails generateBill(Integer customerId, Integer tripBookingId,String key) throws TripBookingException;
	
	public List<TripBooking> getAllTrips(Integer customerId,String key) throws TripBookingException;

}
