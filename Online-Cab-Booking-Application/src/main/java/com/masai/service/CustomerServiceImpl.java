package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;
import com.masai.exceptions.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	@Override
	public Customer createCustomer(Customer customer)throws CustomerException {
		
		
		Customer existingCustomer= cDao.findByMobileNumber(customer.getMobileNumber());
		
	 
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with Mobile number");
			
		
		
		
			return cDao.save(customer);
			
			
		}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		
	
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return cDao.save(customer);
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
	
	}

	@Override
	public Customer deleteCustomer(Customer customer ) throws CustomerException {
		// TODO Auto-generated method stub
		Customer c = cDao.findByCustomerId(customer.getCustomerId());
		
		if(c != null) {
			cDao.delete(c);
			return c;
		}else {
			throw new CustomerException("Customer not found with Id : " +customer.getCustomerId());
		}
		
		
	}

	@Override
	public List<Customer> viewCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customerList = cDao.findAll();
		if(customerList.size() != 0) {
			return customerList;
		}
		else {
			throw new CustomerException("No Customer found");
		}
	
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		Customer customer = cDao.findByCustomerId(customerId);
		if(customer != null ) {
			return customer;
		}
		else {
			throw new CustomerException("No Customer found");
		}

	}
    
	
		
		
	}


