package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetails {
	
	private double ratePerKms;
	private Float distance;
	private Float totalBill;
	
	

}
