package com.aurionrpo.decorator;

import com.aurionrpo.decorator.repo.IHat;
import com.aurionrpo.decorator.services.GoldenHat;

public class HatTest {
	public static void main(String args[]) {
		IHat hat = new StandardHat("Standard Hat", "This is standard hat", 300);
		GoldenHat goldenHat = new GoldenHat(hat);
		System.out.println(goldenHat.getHatPrice());
	}
}
