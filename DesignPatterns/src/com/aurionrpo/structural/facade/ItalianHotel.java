package com.aurionrpo.structural.facade;

import java.util.List;

import com.aurionrpo.structural.facade.repo.IHotel;

public class ItalianHotel implements IHotel {

	@Override
	public List<Food> getMenu() {
		ItalianMenu italianMenu = new ItalianMenu();
		return italianMenu.getItalianFoods();
	}

}
