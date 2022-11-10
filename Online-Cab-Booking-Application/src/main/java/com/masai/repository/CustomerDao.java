package com.masai.repository;

import javax.validation.constraints.NotNull; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {

	public Customer findByMobileNumber(String mobileNo);
	
	public Customer findByCustomerId(Integer customerId);

	
}
