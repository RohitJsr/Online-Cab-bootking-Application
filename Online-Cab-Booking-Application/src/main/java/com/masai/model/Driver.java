package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	private String LicenseId;
	private  float rating;
    
//	@OneToOne(cascade = CascadeType.ALL)
//	private Cab cab;

//	public Cab getCab() {
//		return cab;
//	}
//
//	public void setCab(Cab cab) {
//		this.cab = cab;
//	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getLicenseId() {
		return LicenseId;
	}

	public void setLicenseId(String licenseId) {
		LicenseId = licenseId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	
}
