package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.TripBookingException;
import com.masai.model.TripBooking;
import com.masai.repository.TripBookingDao;


@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	private TripBookingDao tdao;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException {
		// TODO Auto-generated method stub
		TripBooking booking=tdao.save(tripBooking);
		
		if(booking ==null) {
			throw new TripBookingException("Please Enter proper details to start the trip");
		}else {
			return booking;
		}
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		// TODO Auto-generated method stub
		
		//tdao.findById(tripBooking.getTripBookingId()).orElseThrow(() -> new TripBookingException("TripBooking with id : "+ tripBooking.getTripBookingId() + "does not exist"));
		return tdao.save(tripBooking);	
		
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingld) throws TripBookingException {
		// TODO Auto-generated method stub
		TripBooking trip = tdao.findById(tripBookingld).orElseThrow(() -> new TripBookingException("Trip with id : " + tripBookingld + "does not exist"));
		
		tdao.deleteById(tripBookingld);		
		return trip;
	}

//	@Override
//	public List<TripBooking> viewAllTripsCustomer(int customerld) throws TripBookingException {
//		// TODO Auto-generated method stub
//		
//		List<TripBooking> list=tdao.getAllTripsByCustomerId(customerld);
//		
//		if(list.size()==0) throw new TripBookingException("No trip for this customer having id : "+ customerld);
//		
//		return list;
//	}
//
//	@Override
//	public TripBooking calculateBill(int customerld) throws TripBookingException {
//		// TODO Auto-generated method stub
//		TripBooking trip = tdao.getCurrentTripByCustomerId(customerld);
//	
//		return tdao.save(trip);
//	}

}
