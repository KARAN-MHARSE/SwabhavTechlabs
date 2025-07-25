package com.aurionrpo.decorator.services;

import com.aurionrpo.decorator.CarServiceDecorator;
import com.aurionrpo.decorator.repo.ICarService;

public class OilChange extends CarServiceDecorator {

	public OilChange(ICarService service) {
		super(service);
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return 500+super.getCost();
	}

	
	
}
