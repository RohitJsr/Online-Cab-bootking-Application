package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		
		Customer savedCustomer= cService.createCustomer(customer);
		
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer customerId) throws CustomerException{
		
		Customer DeleteCustomer = cService.deleteCustomer(customerId);
		
		return new ResponseEntity<Customer>(DeleteCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> findAllCustomer() throws CustomerException{
		
		List<Customer> customers = cService.viewCustomer();
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	@GetMapping("/findCustomerById")
	public ResponseEntity<Customer> findCustomerById(@RequestParam Integer customerId) throws CustomerException{
		Customer customer = cService.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	


	
	
	
	
	
	
	
	
	
}
