package com.aurionrpo.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class ItalianMenu {
	List<Food> italianFoods = new ArrayList<Food>();

	public ItalianMenu() {
		italianFoods.add(new Food("Biryani"));
		italianFoods.add(new Food("Panir"));
	}

	@Override
	public void displayMenu() {
		italianFoods.forEach(System.out::println);
	}

	public List<Food> getItalianFoods() {
		return italianFoods;
	}

	public void setItalianFoods(List<Food> italianFoods) {
		this.italianFoods = italianFoods;
	}

	
	
}
