package com.masai.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.TripBooking;

public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{
	
}
