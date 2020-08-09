package io.neca.infoservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product_info")
public class ProductInfo {

	@Id
	private String productID;
	private String name;
	private String specs;

	public ProductInfo() {
		super();
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
