package com.aurionpro.foodify.models.foodTypes;

import com.aurionpro.foodify.interfaces.FoodType;

public class ChineseFood implements FoodType {

	@Override
	public double getDiscountPercentage() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getFoodTypeName() {
		// TODO Auto-generated method stub
		return "Chinese";
	}

	@Override
	public String toString() {
		return "Chinese";
	}
}
