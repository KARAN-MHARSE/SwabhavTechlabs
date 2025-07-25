package com.aurionpro.foodify.models;

import java.util.UUID;

import com.aurionpro.foodify.interfaces.FoodType;

public class FoodItem {
//	private UUID id;
	private int id;
	private String name;
	private String description;
	private FoodType foodType;
	private double price;
	
	private static int count =0;
	
	
	public FoodItem(String name, String description, FoodType foodType, double price) {
//		this.id = UUID.randomUUID();
		this.id = 100+count;
		count++;
		this.name = name;
		this.description = description;
		this.foodType = foodType;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getTotalDiscountPrice() {
		return price * foodType.getDiscountPercentage()/100;
	}
	
	public double getPriceAfterDiscount() {
		double discount = price * foodType.getDiscountPercentage()/100;
		return price-discount;
	}

	@Override
	public String toString() {
		return "[\n\t id=" + id + ",\n\t name=" + name + ",\n\t description=" + description + ", \n\t foodType=" + foodType
				+ ",\n\t price=" + price + "\n]";
	}
	
	
	
	

}
