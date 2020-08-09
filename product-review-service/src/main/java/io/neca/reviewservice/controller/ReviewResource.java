package io.neca.reviewservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.neca.reviewservice.model.Review;
import io.neca.reviewservice.repository.ReviewRepository;

@RestController
@RequestMapping("/review")
public class ReviewResource {

	@Autowired
	ReviewRepository repo;
	
	@GetMapping("/{productID}")
	public Optional<Review> getReview(@PathVariable String productID) {
		
		return repo.findById(productID);
	}
	
}
