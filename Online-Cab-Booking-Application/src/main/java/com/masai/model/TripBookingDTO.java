package com.masai.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class TripBookingDTO {
	
	private Integer tripId;
	
	private Integer customerId;
	
	private String fromLocation;
	
	private String toLocation;
	
	private LocalDateTime fromTime;
	
	private LocalDateTime toTime;

	
	
	

}
