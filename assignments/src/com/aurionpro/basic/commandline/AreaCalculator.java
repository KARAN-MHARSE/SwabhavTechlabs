package com.aurionpro.basic.commandline;

public class AreaCalculator {
	private static double calculateArea(double radius) {
		return 3.14 * radius * radius;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius = Double.parseDouble(args[0]);
		double area = calculateArea(radius);
		System.out.println("Area of circle is " + area);
		

	}

}
