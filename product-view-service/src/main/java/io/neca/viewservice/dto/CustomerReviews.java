package io.neca.viewservice.dto;

import java.util.List;

public class CustomerReviews {

	private List<Review> reviews;

	public CustomerReviews() {
		super();
	}

	public CustomerReviews(List<Review> reviews) {
		super();
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
