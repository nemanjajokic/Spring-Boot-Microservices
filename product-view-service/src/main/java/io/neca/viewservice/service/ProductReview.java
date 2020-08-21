package io.neca.viewservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.neca.viewservice.model.Review;

@Service
public class ProductReview {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackReview")
	public Review getReview(@PathVariable("productID") String productID) {
		return restTemplate.getForObject("http://product-review-service/review/" + productID, Review.class);
	}
	
	public Review fallbackReview(@PathVariable("productID") String productID) {
		return new Review(productID, "not found", "");
	}
	
}
