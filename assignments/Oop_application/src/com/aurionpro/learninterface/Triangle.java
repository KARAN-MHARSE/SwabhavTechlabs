package com.aurionpro.learninterface;

import java.nio.file.attribute.AclEntry;

public class Triangle implements Shape {
	private int base;
	private int height;
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public void area() {
		System.out.println("The area of triangle is: "+ (int)(0.5*base*height));
		
	}

	@Override
	public void surfaceArea() {
		System.out.println("The surface area of triangle is: "+ (int)(base*height));
		
	}

}
