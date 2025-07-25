package com.aurionrpo.decorator.services;

import com.aurionrpo.decorator.HatDecorator;
import com.aurionrpo.decorator.repo.IHat;

public class GoldenHat extends HatDecorator{

	public GoldenHat(IHat hat) {
		super(hat);
		// TODO Auto-generated constructor stub
	}
	
	public double getHatPrice(double amount) {
		return super.getHatPrice()+amount;
	}

	@Override
	public String getHatName() {
		// TODO Auto-generated method stub
		return "Golden Hat";
	}

	@Override
	public String getHatDescription() {
		// TODO Auto-generated method stub
		return "This is golden hat";
	}

}
