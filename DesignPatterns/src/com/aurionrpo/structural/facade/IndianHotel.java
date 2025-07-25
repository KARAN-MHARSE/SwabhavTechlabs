package com.aurionrpo.structural.facade;

import java.util.List;

import com.aurionrpo.structural.facade.repo.IHotel;

public class IndianHotel implements IHotel {

	@Override
	public List<Food> getMenu() {
		IndianMenu indianMenu = new IndianMenu();
		return indianMenu.getIndianFoods();
		
		
	}

}
