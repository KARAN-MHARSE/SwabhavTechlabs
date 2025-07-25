package com.aurionpr.test;

import com.aurionpro.model.Rectangle;

public class StaticKeyword {

	public static void main(String[] args) throws ClassNotFoundException {
//		Rectangle rectangle;
//		System.out.println("Hii");

//		Rectangle rectangle = new Rectangle(10, 20);
//		System.out.println("Done");

		Class.forName("com.aurionpro.model.Rectangle");
		System.out.println("Good Bye");	
//		StaticKeyword staticKeyword = new StaticKeyword();
//		staticKeyword.main(new String[1]);
//		
//		
//		Rectangle rectangle1 = new Rectangle(10,20);
//		System.out.println(rectangle1);
//		
//		Rectangle rectangle2 = new Rectangle(10,30);
//		System.out.println(rectangle2);
//		
//		System.out.println("Before increment");
//		System.out.println(rectangle1);
//		System.out.println(rectangle2);

//		System.out.println(rectangle1.breath);
//		System.out.println(Rectangle.breath);
	}

	static {
		System.out.println("Inner block in main class");
	}

}
