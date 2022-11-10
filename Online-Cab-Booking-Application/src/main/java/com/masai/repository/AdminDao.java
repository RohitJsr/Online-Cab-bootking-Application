package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Driver;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>   {

	public Admin findByMobileNumber(String mobileNo);
	
	public Admin findByAdminId(Integer AdminId);
	
}
