package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	
	public Customer createCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;
	
	public String deleteCustomer(Integer customerId ,String key)throws CustomerException;
	
	public List<Customer> viewCustomerAll(Integer customerId,String key) throws CustomerException;
	
	public Customer viewCustomer(Integer customerId,String key) throws CustomerException;

}
