package com.aurionrpo.factory;

public class Car implements IVehicle{

	@Override
	public void start() {
		System.out.println("Car Started");
		
	}

	@Override
	public void stop() {
		System.out.println("Car stopped");
		
	}

}
