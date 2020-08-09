package io.neca.reviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.neca.reviewservice.model.Review;

public interface ReviewRepository extends JpaRepository<Review, String>{

}
