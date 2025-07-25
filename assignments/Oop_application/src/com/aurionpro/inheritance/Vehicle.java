package com.aurionpro.inheritance;

public class Vehicle {
	private String model;
	private int year;
	private double price;
	
	
	
	public Vehicle() {
		this("S101", 2025, 40000);
	}
	public Vehicle(String model, int year, double price) {
		this.model = model;
		this.year = year;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void startEngine() {
		System.out.println("Engine started");
	}
	public void stopEngine() {
		System.out.println("Engine stoped");
	}
	public void displayInfo() {
		System.out.println("Model:" + model +"\nYear: "+year+"\nprice:"+price);
	}
	
	public void lockDoors() {
		System.out.println("All doors are locked");
	}
	
	public void unlockDoors() {
		System.out.println("All doors are unlocked");
	}
	
	
}
