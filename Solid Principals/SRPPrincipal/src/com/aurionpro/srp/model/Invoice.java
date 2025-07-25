package com.aurionpro.srp.model;

public class Invoice {
	private int id;
	private String productName;
	private String description;
	private double cost;
	private double discountPercentage;
	private double costTax;
	
	public Invoice(int id, String productId, String description, double cost, double discountPercentage,
			double costTax) {
		super();
		this.id = id;
		this.productName = productId;
		this.description = description;
		this.cost = cost;
		this.discountPercentage = discountPercentage;
		this.costTax = costTax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productId) {
		this.productName = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getCostTax() {
		return costTax;
	}

	public void setCostTax(double costTax) {
		this.costTax = costTax;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", productName=" + productName + ", description=" + description + ", cost=" + cost
				+ ", discountPercentage=" + discountPercentage + ", costTax=" + costTax + "]";
	}
	
	

}
