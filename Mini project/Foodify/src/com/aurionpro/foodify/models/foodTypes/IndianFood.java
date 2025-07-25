package com.aurionpro.foodify.models.foodTypes;

import com.aurionpro.foodify.interfaces.Discount;
import com.aurionpro.foodify.interfaces.FoodType;

public class IndianFood implements FoodType {

	@Override
	public double getDiscountPercentage() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getFoodTypeName() {
		// TODO Auto-generated method stub
		return "Indian";
	}

	@Override
	public String toString() {
		return "Indian";
	}

}
