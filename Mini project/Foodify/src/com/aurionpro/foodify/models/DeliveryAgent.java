package com.aurionpro.foodify.models;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgent extends User {
	List<Order> orders;
	
	public DeliveryAgent(String name, Address adress, String email, Long mobileNumber, String password) {
		super(name, adress, email, mobileNumber, password);
		orders =  new ArrayList<Order>();
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

	
	

}
