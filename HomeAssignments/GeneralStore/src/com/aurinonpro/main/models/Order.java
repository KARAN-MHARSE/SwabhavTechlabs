package com.aurinonpro.main.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private LocalDate localDate;
	private List<LineItem> lineItems= new ArrayList<>();
	private boolean isCompleted;
	private static int count = 0;
	
	public Order(LineItem items) {
		this.orderId = 300+count;
		count++;
		this.localDate = LocalDate.now();
		this.localDate = localDate;
		this.lineItems.add(items);
		this.isCompleted = false;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public double calculateOrderPrice() {
		int totalPrice =0;
		for(LineItem item : lineItems) {
			totalPrice += item.calculateLineItemCost();
		}
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", localDate=" + localDate + ",\n items=" + lineItems + "\n\t Order price= "+calculateOrderPrice()+ "]";
	}
	
	
	
	
	

}
