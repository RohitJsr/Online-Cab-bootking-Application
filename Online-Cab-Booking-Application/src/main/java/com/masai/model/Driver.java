package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;

	
    
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cab cab;
	
	
	@OneToMany(cascade = CascadeType.ALL,  mappedBy = "driver", orphanRemoval = true)
	@JsonIgnore
	List<TripBooking> tripBookingList = new ArrayList<>();
	
	
	private String licenseNumber;
	
	
	private Boolean availablity = true;



	
}
