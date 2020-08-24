package io.neca.viewservice.dto;

public class Product {

	private String productName;
	private String productInfo;
	private String customerName;
	private String review;

	public Product() {
		super();
	}

	public Product(String productName, String productInfo, String customerName, String review) {
		super();
		this.productName = productName;
		this.productInfo = productInfo;
		this.customerName = customerName;
		this.review = review;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
