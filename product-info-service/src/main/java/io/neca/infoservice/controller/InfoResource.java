package io.neca.infoservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.neca.infoservice.model.ProductInfo;
import io.neca.infoservice.repository.ProductInfoRepository;

@RestController
@RequestMapping("/info")
public class InfoResource {

	@Autowired
	ProductInfoRepository repo;
	
	@GetMapping("/{productID}")
	public Optional<ProductInfo> getProductInfo(@PathVariable String productID) {

		return repo.findById(productID);
	}
	
}
