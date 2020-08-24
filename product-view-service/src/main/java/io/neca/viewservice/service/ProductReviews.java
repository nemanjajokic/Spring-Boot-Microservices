package io.neca.viewservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.neca.viewservice.dto.CustomerReviews;

@Service
public class ProductReviews {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallBackReviews")
	public CustomerReviews getAllReviews() {
		
		return restTemplate.getForObject("http://product-review-service/review/all", CustomerReviews.class);
	}
	
	public CustomerReviews fallBackReviews() throws Exception {		// Add exception class
		throw new Exception("not found");
	}
	
}
