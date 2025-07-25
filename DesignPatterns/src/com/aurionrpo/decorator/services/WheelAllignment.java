package com.aurionrpo.decorator.services;

import com.aurionrpo.decorator.CarServiceDecorator;
import com.aurionrpo.decorator.repo.ICarService;

public class WheelAllignment extends CarServiceDecorator {

	public WheelAllignment(ICarService service) {
		super(service);
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return 800+super.getCost();
	}

}
