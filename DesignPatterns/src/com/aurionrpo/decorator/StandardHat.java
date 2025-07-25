package com.aurionrpo.decorator;

import com.aurionrpo.decorator.repo.IHat;

public class StandardHat implements IHat {
	private String name;
	private String Description;
	private double price;
	

	public StandardHat(String name, String description, double price) {
		super();
		this.name = name;
		Description = description;
		this.price = price;
	}

	@Override
	public String getHatName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getHatPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHatDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
