package com.aurionrpo.structural.facade.repo;

import java.util.List;

import com.aurionrpo.structural.facade.Food;
import com.aurionrpo.structural.facade.IMenu;

public interface IHotel {
	List<Food> getMenu();
}
