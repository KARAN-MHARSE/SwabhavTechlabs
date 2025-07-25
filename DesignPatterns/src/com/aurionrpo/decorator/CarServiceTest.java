package com.aurionrpo.decorator;

import com.aurionrpo.decorator.repo.ICarService;
import com.aurionrpo.decorator.services.CarInspection;
import com.aurionrpo.decorator.services.OilChange;
import com.aurionrpo.decorator.services.WheelAllignment;

public class CarServiceTest {
	public static void main(String args[]) {
		ICarService carService = new CarInspection();
		OilChange oilChange = new OilChange(carService);
		WheelAllignment wheelAllignment = new WheelAllignment(oilChange);
		
		System.out.println(wheelAllignment.getCost());
	}

}
