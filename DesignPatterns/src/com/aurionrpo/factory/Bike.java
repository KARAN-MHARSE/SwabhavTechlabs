package com.aurionrpo.factory;

public class Bike  implements IVehicle{

	@Override
	public void start() {
		System.out.println("Bike started");
		
	}

	@Override
	public void stop() {
		System.out.println("Bike stopped");
		
	}

}
