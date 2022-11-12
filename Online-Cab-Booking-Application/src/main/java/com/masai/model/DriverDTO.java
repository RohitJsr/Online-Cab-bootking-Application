package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO extends User{
	
private String licenseNumber;
	
	private String numberPlate;
	
	private Float ratePerKms;
	
	private String carType;
	
	private int driverId;

}
