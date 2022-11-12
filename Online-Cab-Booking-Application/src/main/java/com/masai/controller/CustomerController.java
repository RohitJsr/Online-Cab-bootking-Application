package com.masai.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.TripBookingException;
import com.masai.model.BillDetails;
import com.masai.model.Customer;
import com.masai.model.TripBookingDTO;
import com.masai.service.CustomerService;
import com.masai.service.TripBookingService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private TripBookingService tService;
	
	@PostMapping("/create")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		
		Customer savedCustomer= cService.createCustomer(customer);
		
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public  ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) throws CustomerException{
		
		String DeleteCustomer = cService.deleteCustomer(customer);
		
		return new ResponseEntity<String>(DeleteCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Customer>> findAllCustomer() throws CustomerException{
		
		List<Customer> customers = cService.viewCustomer();
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	@GetMapping("/viewById")
	public ResponseEntity<Customer> findCustomerById(@RequestParam Integer customerId) throws CustomerException{
		Customer customer = cService.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	@PostMapping("generateBill")
	public ResponseEntity<BillDetails> generateBillHandler(@RequestBody TripBookingDTO tripBooking) throws TripBookingException{
		BillDetails billDetails = tService.generateBill(tripBooking);
		return new ResponseEntity<BillDetails>(billDetails,HttpStatus.OK);
	}
	


	
	
	
	
	
	
	
	
	
}
