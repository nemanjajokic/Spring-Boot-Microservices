package io.neca.viewservice.model;

public class ProductInfo {

	private String productID;
	private String name;
	private String specs;

	public ProductInfo() {
		super();
	}

	public ProductInfo(String productID, String name, String specs) {
		super();
		this.productID = productID;
		this.name = name;
		this.specs = specs;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

}
