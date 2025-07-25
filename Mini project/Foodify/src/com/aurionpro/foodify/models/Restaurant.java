package com.aurionpro.foodify.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Restaurant {
	private UUID id;
	private String name;
	private RestaurantManager restaurantManager;
	private Map<UUID, FoodItem> foodItems;
	private List<Order> orders;
	private List<Payment> paymentHistoy;
	
	public Restaurant(String name, RestaurantManager restaurantManager) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.restaurantManager = restaurantManager;
		this.foodItems = new HashMap<UUID, FoodItem>();
		this.orders = new ArrayList<Order>();
		this.paymentHistoy = new ArrayList<Payment>();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestaurantManager getRestaurantManager() {
		return restaurantManager;
	}

	public void setRestaurantManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	public Map<UUID, FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(Map<UUID, FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Payment> getPaymentHistoy() {
		return paymentHistoy;
	}

	public void setPaymentHistoy(List<Payment> paymentHistoy) {
		this.paymentHistoy = paymentHistoy;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", restaurantManager=" + restaurantManager + ", foodItems="
				+ foodItems + ", orders=" + orders + ", paymentHistoy=" + paymentHistoy + "]";
	}
	
	
	
	
	
	
	

}
