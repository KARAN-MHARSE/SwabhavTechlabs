package com.aurionrpo.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class IndianMenu  implements IMenu{
	List<Food> indianFoods = new ArrayList<Food>();
	
	public IndianMenu() {
		indianFoods.add(new Food("Biryani"));
		indianFoods.add(new Food("Panir"));
	}

	@Override
	public void displayMenu() {
		indianFoods.forEach(System.out::println);
	}

	public List<Food> getIndianFoods() {
		return indianFoods;
	}

	public void setIndianFoods(List<Food> indianFoods) {
		this.indianFoods = indianFoods;
	}

}
