package com.aurionpro.learninterface;

public class Test {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle(20, 10);
		Shape triangle = new Triangle(20, 15);
		
		rectangle.area();
		triangle.area();

	}

}
