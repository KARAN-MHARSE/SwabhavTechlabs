package com.aurionpro.inheritance;

public class Car extends Vehicle{
	private int numberOfDoors;

	
	
	public Car() {
		this("",2025,500000,4);
	}

	public Car(String model, int year, double price,int numberOfDoors) {
		super(model,year,price);
		this.numberOfDoors = numberOfDoors;
	}
	
	public static void printCar() {
		System.out.println("Done");
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	
	
}