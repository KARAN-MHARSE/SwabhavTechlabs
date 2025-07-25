package com.aurionpro.learninterface;

public class Rectangle implements Shape {
	private int length;
	private int breadth;
	
	public Rectangle(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public void area() {
		System.out.println("Area of rectangle is: "+ (int)(length*breadth));
		
	}

	@Override
	public void surfaceArea() {
		// TODO Auto-generated method stub
		
	}

}
