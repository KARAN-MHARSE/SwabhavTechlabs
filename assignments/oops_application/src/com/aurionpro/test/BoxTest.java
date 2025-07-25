package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Box;

public class BoxTest {
	private static Box createBox(Scanner scanner) {
		System.out.println("Enter the length:");
		int length = scanner.nextInt();
		
		System.out.println("Enter the width");
		int width = scanner.nextInt();
		
		System.out.println("Enter the height");
		int height = scanner.nextInt();
		
		Box box = new Box(length,width,height);
		return box;
	}

	public static void main(String[] args) {
//		Box box1 = new Box(10,20,30);
//		
//		box1.setLength(10);
//		System.out.println("The length of the box1 is "+ box1.getLength());
//		
//		Box box2 = new Box(40,50,60);		
////		box2.setLength(50);
////		box2.setBreadth(60);
////		box2.setDepth(55);
//		System.out.println("The length of the box2 is "+ box2.getLength());
		
		Scanner scanner = new Scanner(System.in);
		
		
//		BoxTest test = new BoxTest();
		
		Box box1 = createBox(scanner);
		box1.display();
		
		Box box2 = createBox(scanner);
		box2.display();
		
		

	}

}
