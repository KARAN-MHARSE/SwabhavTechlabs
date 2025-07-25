package com.aurionrpo.factory;

public class Test {
	public static void main(String args[]) {
		VehicleFactory vehicleFactory = new VehicleFactory();
		
		IVehicle car = vehicleFactory.getVehicle("Car");
		car.start();
		car.stop();
		
		IVehicle bike = vehicleFactory.getVehicle("bike");
		bike.start();
		bike.stop();
	}

}
