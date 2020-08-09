package io.neca.reviewservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	private String productID;
	private String customerID;
	private String comment;

	public Review() {
		super();
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
