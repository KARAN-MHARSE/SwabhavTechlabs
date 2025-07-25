package com.aurionpro.basic;
import java.util.*;


public class AreaOfCircle {

	static double area(int radius) {
		return (2 * Math.PI * radius);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the length of radius: ");
		Scanner scanner = new Scanner(System.in);
		
		int radius = scanner.nextInt();
		double ans = area(radius);
		
		System.out.println(ans);

	}

}
