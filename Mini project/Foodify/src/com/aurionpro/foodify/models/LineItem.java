package com.aurionpro.foodify.models;

import java.util.UUID;

public class LineItem {

	private UUID id;
	private FoodItem foodItem;
	private int quantity;

	public LineItem(FoodItem foodItem, int quantity) {
		this.id = UUID.randomUUID();
		this.foodItem = foodItem;
		this.quantity = quantity;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscountPrice() {
		return foodItem.getTotalDiscountPrice() * quantity;
	}

	public double getTotalPrice() {
		return foodItem.getPriceAfterDiscount() * quantity;
	}

	public double getOriginalLineItemPrice() {
		return foodItem.getPrice()*quantity;
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", \n\t foodItem=" + foodItem + ",\n\t quantity=" + quantity
				+ ",\n\t LineItemPrice=" + getTotalPrice() + "\n]";
	}

}
