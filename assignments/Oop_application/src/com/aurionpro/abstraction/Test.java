package com.aurionpro.abstraction;

import java.util.ArrayList;
abstract class A{
	public abstract void display();
}

abstract class B extends A{
	
}
class C extends B{

	@Override
	final public void display() {
		// TODO Auto-generated method stub
		System.out.println("DOne");
	}
	
}

public class Test {

	public static void main(String[] args) {
//		ArrayList<Shape> shapes = new ArrayList<Shape>();
//		
//		Shape rectangle = new Rectangle(10, 20);
//		Shape triangle = new Triangle(20, 10);
//		
//		shapes.add(rectangle);
//		shapes.add(triangle);
//		
//		shapes.get(0).area();
//
//		rectangle.area();
//		triangle.area();

		C c = new C();
		c.display();
	}

}
