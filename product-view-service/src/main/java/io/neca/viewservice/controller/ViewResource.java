package io.neca.viewservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{productID}")
	public Product getProduct(@PathVariable String productID) {
		
		Review review = productReview.getReview(productID);
		Customer customer = customerInfo.getCustomerInfo(review.getCustomerID());
		ProductInfo productInfo = productInfoService.getProductinfo(productID);

		return new Product(productInfo.getName(), productInfo.getSpecs(), customer.getName(), review.getComment());
	}

//	@GetMapping("/all")		//test productReviews
//	public CustomerReviews getAllProducts() {
//		
//		return productReviews.getAllReviews();
//	}
	
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
	
}
