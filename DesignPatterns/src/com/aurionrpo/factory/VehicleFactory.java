package com.aurionrpo.factory;

public class VehicleFactory {

	public IVehicle getVehicle(String vehicleType) {
		if(vehicleType.equalsIgnoreCase("Car")) {
			return new Car();
		}
		return new Bike();
	}
}
