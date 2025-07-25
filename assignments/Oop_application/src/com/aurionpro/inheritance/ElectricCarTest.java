package com.aurionpro.inheritance;

public class ElectricCarTest {

	public static void main(String[] args) {
		ElectricCar electricCar = new ElectricCar("Mahindra Thar",2024,1300000,4,70);
		
		electricCar.startEngine();
		electricCar.unlockDoors();
		electricCar.displayInfo();
		electricCar.displayBatteryStatus();
		electricCar.chargeBattery();
		electricCar.displayBatteryStatus();
		electricCar.lockDoors();		
		electricCar.startEngine();
		electricCar.printCar();

	}

}
