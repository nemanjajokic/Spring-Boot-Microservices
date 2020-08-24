package io.neca.viewservice.dto;

public class Review {

	private String productID;
	private String customerID;
	private String comment;

	public Review() {
		super();
	}

	public Review(String productID, String customerID, String comment) {
		super();
		this.productID = productID;
		this.customerID = customerID;
		this.comment = comment;
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
