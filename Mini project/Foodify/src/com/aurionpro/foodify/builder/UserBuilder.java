package com.aurionpro.foodify.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.aurionpro.foodify.models.Address;
import com.aurionpro.foodify.models.Customer;
import com.aurionpro.foodify.models.DeliveryAgent;
import com.aurionpro.foodify.models.Order;
import com.aurionpro.foodify.models.Restaurant;
import com.aurionpro.foodify.models.RestaurantManager;

public class UserBuilder {
	private UUID id;
	private String name;
	private Address address;
	private String email;
	private Long mobileNumber;
	private String password;
	
	//Customer || delivery agent
	private List<Order> orders = new ArrayList<Order>();
	
	//manager
	private UUID restaurantId;

	public UserBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setAdress(Address address) {
		this.address = address;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder setOrders(List<Order> orders) {
		this.orders = orders;
		return this;
	}

	public UserBuilder setRestaurantId(UUID restaurantId) {
		this.restaurantId = restaurantId;
		return this;
	}
	
	public Customer buildCustomer() {
		return new Customer(name, address, email, mobileNumber, password);
	}
	
	public RestaurantManager buildRestaruntManager() {
		return new RestaurantManager(name, address, email, mobileNumber, password, restaurantId);
	}
	
	public DeliveryAgent buildDeliveryAgent() {
		return new DeliveryAgent(name, address, email, mobileNumber, password);
	}
	
	

	


}
