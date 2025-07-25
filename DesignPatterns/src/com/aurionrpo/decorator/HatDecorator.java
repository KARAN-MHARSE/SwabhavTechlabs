package com.aurionrpo.decorator;

import com.aurionrpo.decorator.repo.IHat;

public abstract class HatDecorator implements IHat {
	IHat hat;
	
	public HatDecorator(IHat hat) {
		this.hat = hat;
	}

	
	@Override
	public double getHatPrice() {
		// TODO Auto-generated method stub
		return hat.getHatPrice();
	}

	

}
