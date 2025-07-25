package com.aurionrpo.decorator;

import com.aurionrpo.decorator.repo.ICarService;

public abstract class CarServiceDecorator implements ICarService {
	private ICarService service;
	
	public CarServiceDecorator(ICarService service) {
		this.service = service;
	}
	
	
	public double getCost() {
		// TODO Auto-generated method stub
		return service.getCost();
	}
	
	

}
