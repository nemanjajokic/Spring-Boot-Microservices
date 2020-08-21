package io.neca.viewservice.model;

public class Customer {

	private String customerID;
	private String name;

	public Customer() {
		super();
	}

	public Customer(String customerID, String name) {
		super();
		this.customerID = customerID;
		this.name = name;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
