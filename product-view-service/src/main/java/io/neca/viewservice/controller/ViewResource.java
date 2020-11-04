package io.neca.viewservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.neca.viewservice.dto.Customer;
import io.neca.viewservice.dto.CustomerReviews;
import io.neca.viewservice.dto.Product;
import io.neca.viewservice.dto.ProductInfo;
import io.neca.viewservice.dto.Products;
import io.neca.viewservice.dto.Review;
import io.neca.viewservice.service.CustomerInfo;
import io.neca.viewservice.service.ProductInfoService;
import io.neca.viewservice.service.ProductReview;
import io.neca.viewservice.service.ProductReviews;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API Documentation test by Neca")
@CrossOrigin("*")	// FIX THIS
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
	@Autowired
	ProductReviews productReviews;
	
	@ApiOperation("Customer search for products by ID")
	@GetMapping("/{productID}")
	public Product getProduct(@PathVariable String productID) {
		
		Review review = productReview.getReview(productID);
		Customer customer = customerInfo.getCustomerInfo(review.getCustomerID());
		ProductInfo productInfo = productInfoService.getProductinfo(productID);

		return new Product(productInfo.getName(), productInfo.getSpecs(), customer.getName(), review.getComment());
	}
	
	@GetMapping("/all")
	public Products getAllProducts() {
		CustomerReviews reviews = productReviews.getAllReviews();
		Products products = new Products();
		
		List<Product> productsList = reviews.getReviews().stream().map(r -> {
			Customer customer = customerInfo.getCustomerInfo(r.getCustomerID());
			ProductInfo productInfo = productInfoService.getProductinfo(r.getProductID());
			
			return new Product(productInfo.getName(), productInfo.getSpecs(), customer.getName(), r.getComment());
		}).collect(Collectors.toList());
		
		products.setProducts(productsList);
		
		return products;
	}
	
//	@GetMapping("/all")
//	public List<Product> getAllProducts() {
//		CustomerReviews reviews = productReviews.getAllReviews();
//		
//		return reviews.getReviews().stream().map(r -> {
//			Customer customer = customerInfo.getCustomerInfo(r.getCustomerID());
//			ProductInfo productInfo = productInfoService.getProductinfo(r.getProductID());
//			
//			return new Product(productInfo.getName(), productInfo.getSpecs(), customer.getName(), r.getComment());
//		}).collect(Collectors.toList());
//		
//	}
	
}
