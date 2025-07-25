package com.aurionpro.foodify.models.foodTypes;

import com.aurionpro.foodify.interfaces.FoodType;

public class ItalianFood implements FoodType {

	@Override
	public double getDiscountPercentage() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getFoodTypeName() {
		// TODO Auto-generated method stub
		return "Italian";
	}

	@Override
	public String toString() {
		return "Italian";
	}
	
	

}
