package com.aurionrpo.factory;

interface IShape {
	void draw();
}

class Circle implements IShape {

	@Override
	public void draw() {
		System.out.println("Drawing circle");

	}

}

class Rectangle implements IShape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Rectangle");
	}

}

class ShapeFactory {
	public static IShape getShape(String shapeName) {
		if (shapeName.equalsIgnoreCase("Circle")) {
			return new Circle();
		}
		if (shapeName.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}
		return null;
	}
}

public class ShapeExample {
	public static void main(String args[]) {
		IShape circle = ShapeFactory.getShape("circle");
		circle.draw();
		IShape rectangle = ShapeFactory.getShape("Rectangle");
		rectangle.draw();
	}
}
