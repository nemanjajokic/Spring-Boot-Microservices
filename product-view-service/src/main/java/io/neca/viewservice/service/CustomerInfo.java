package io.neca.viewservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.neca.viewservice.model.Customer;

@Service
public class CustomerInfo {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackCustomer")
	public Customer getCustomerInfo(String customerID) {
		return restTemplate.getForObject("http://customer-info-service/customer/" + customerID, Customer.class);
	}
	
	public Customer fallbackCustomer(String customerID) {
		return new Customer(customerID, "not found");
	}
	
}
