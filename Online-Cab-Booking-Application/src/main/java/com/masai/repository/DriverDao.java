package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
import com.masai.model.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver,Integer>{
	
	public Driver findByMobileNumber(String mobileNo);
	
    public Driver findByDriverId(Integer driverId);

}
