package io.neca.viewservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.neca.viewservice.model.Customer;
import io.neca.viewservice.model.Product;
import io.neca.viewservice.model.ProductInfo;
import io.neca.viewservice.model.Review;

@RestController
@RequestMapping("/product")
public class ViewResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	// get all reviewed products
	@GetMapping("/{productID}")
	public Product getProduct(@PathVariable String productID) {
		// get product review
		Review review = restTemplate.getForObject("http://product-review-service/review/" + productID, Review.class);
		// get customer info
		Customer customer = restTemplate.getForObject("http://customer-info-service/customer/" + review.getCustomerID(), Customer.class);
		// get product info
		ProductInfo productInfo = restTemplate.getForObject("http://product-info-service/info/" + productID, ProductInfo.class);

		return new Product(productInfo.getName(), productInfo.getSpecs(), customer.getName(), review.getComment());
	}
	
}
