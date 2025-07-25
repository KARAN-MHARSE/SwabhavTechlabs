package com.aurionpro.basic;

import java.util.Scanner;

public class DistanceCalculator {

	private static double distanceCalculator(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the x and y co-ordinates of first point");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();

		System.out.println("Enter the x and y co-ordinates of second point");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();

		double distance = distanceCalculator(x1, y1, x2, y2);

		System.out.println("The distance betweeen given two point is : " + distance);

	}
}
