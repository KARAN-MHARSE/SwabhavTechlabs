package com.aurionpro.inheritance;

public class ElectricCar extends Car {

	private float batteryLevel;

	public ElectricCar() {
		this("",2025,50000,4,80);
	}
//	public ElectricCar(String )

	public ElectricCar(String model,int year,int price,int numberOfDoors,float batteryLevel) {
		super(model,year,price,numberOfDoors);
		this.batteryLevel = batteryLevel;
	}
	
	public void chargeBattery() {
		
		if (batteryLevel == 100) {
			System.out.println("Battery is already charged");
			return;
		}
		System.out.println("Battery charging started");
		batteryLevel = 100;
	}
	
	public void displayBatteryStatus() {
		System.out.println("Current battery percentage is: "+batteryLevel);
	}
	
	
	
}
