package com.aurinonpro.main.models;

public class Product {
	private int productId;
	private String productName;
	private double productPrice;
	private double discountPercent;

	private static int count = 0;

	public Product() {
		super();
	}

	public Product(String productName, double productPrice, double discountPercent) {
		super();
		this.productId = 100+count;
		count++;
		this.productName = productName;
		this.productPrice = productPrice;
		this.discountPercent = discountPercent;
	}
	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public double calculateDiscountedPrice() {
		return this.productPrice - (productPrice*discountPercent/100);
	}

	@Override
	public String toString() {
		return " [ProductId=" + productId + ", Product Name=" + productName + ", Product Price=" + productPrice
				+ ", discountPercent=" + discountPercent + "]";
	}

	
}
