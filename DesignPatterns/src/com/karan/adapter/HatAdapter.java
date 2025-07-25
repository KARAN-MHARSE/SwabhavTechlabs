package com.karan.adapter;

public class HatAdapter implements IItem {
	private Hat hat;

	public HatAdapter(Hat hat) {
		this.hat = hat;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return hat.getLongName()+" "+ hat.getShortName();
	}

	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		double tax = hat.getBasePrice() * hat.getTax() /100;
		return  hat.getBasePrice()+tax;
	}

}
