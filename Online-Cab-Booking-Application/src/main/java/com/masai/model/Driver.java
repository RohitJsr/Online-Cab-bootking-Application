package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String licenceNo;
	private  float rating;

}
