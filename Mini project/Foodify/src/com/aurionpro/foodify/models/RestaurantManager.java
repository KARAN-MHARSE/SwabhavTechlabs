package com.aurionpro.foodify.models;

import java.util.UUID;

public class RestaurantManager extends User {
	private UUID restaurantId;

	public RestaurantManager(String name, Address adress, String email, Long mobileNumber,String password, UUID restaurantId) {
		super(name, adress, email, mobileNumber,password);
		this.restaurantId = restaurantId;
	}

	public UUID getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(UUID restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "RestaurantManager [restaurantId=" + restaurantId + "]";
	}
	
	
	
	

}
