package io.neca.viewservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.neca.viewservice.model.ProductInfo;

@Service
public class ProductInfoService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackProductInfo")
	public ProductInfo getProductinfo(@PathVariable("productID") String productID) {
		return restTemplate.getForObject("http://product-info-service/info/" + productID, ProductInfo.class);
	}
	
	public ProductInfo fallbackProductInfo(@PathVariable("productID") String productID) {
		return new ProductInfo(productID, "not found", "");
	}
	
}
