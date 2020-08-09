package io.neca.customerinfoservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.neca.customerinfoservice.model.Customer;
import io.neca.customerinfoservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/{customerID}")
	public Optional<Customer> getCustomer(@PathVariable String customerID) {
		
		return repo.findById(customerID); 
	}
	
}
