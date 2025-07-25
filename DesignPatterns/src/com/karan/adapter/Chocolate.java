package com.karan.adapter;

public class Chocolate implements IItem {
	private String name;
	private double price;
	
	
	

	public Chocolate(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
