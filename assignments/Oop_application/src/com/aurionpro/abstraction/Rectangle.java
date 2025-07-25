package com.aurionpro.abstraction;

import java.text.BreakIterator;

import com.aurionpro.abstraction.*;

public class Rectangle extends Shape {
	private int length;
	private int breadth;
	public Rectangle(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}
	
	@Override
	public void area() {
		System.out.println("Area of rectangle: " + (int)(length*breadth));
	}
}
