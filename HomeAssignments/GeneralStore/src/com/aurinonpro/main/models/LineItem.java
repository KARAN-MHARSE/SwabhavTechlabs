package com.aurinonpro.main.models;

public class LineItem {
	private int lineItemId;
	private int quantity;
	private Product product;
	private static int count =0;
	
	public LineItem(int quantity, Product product) {
		super();
		this.lineItemId = 200+count;
		count++;
		this.quantity = quantity;
		this.product = product;
	}

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		LineItem.count = count;
	}

	public double calculateLineItemCost() {
		return quantity*product.calculateDiscountedPrice();
	}
	@Override
	public String toString() {
		return "\nLineItem [lineItemId=" + lineItemId + ", quantity=" + quantity + ",\n\t product=" + product + " \n\t Cart Price= "+ calculateLineItemCost()+"\n]";
	}
	
	
	
	
}
