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
import io.neca.viewservice.service.CustomerInfo;
import io.neca.viewservice.service.ProductInfoService;
import io.neca.viewservice.service.ProductReview;

@RestController
@RequestMapping("/product")
public class ViewResource {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ProductReview productReview;
	@Autowired
	CustomerInfo customerInfo;
	@Autowired
	ProductInfoService productInfoService;
	
	@GetMapping("/{productID}")
	public Product getProduct(@PathVariable String productID) {
		
		Review review = productReview.getReview(productID);
		Customer customer = customerInfo.getCustomerInfo(review.getCustomerID());
		ProductInfo productInfo = productInfoService.getProductinfo(productID);

		return new Product(productInfo.getName(), productInfo.getSpecs(), customer.getName(), review.getComment());
	}
	
}
