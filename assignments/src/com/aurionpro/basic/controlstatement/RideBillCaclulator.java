package com.aurionpro.basic.controlstatement;

import java.util.Scanner;

public class RideBillCaclulator {

	public static void main(String[] args) {
		int bill = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome, In our Ride bill calculator application");

		System.out.println("Enter your height in cm:");
		int height = scanner.nextInt();

		if (height <= 120) {
			System.out.println("Can't ride");
		} else {
			System.out.println("Can ride");
			System.out.println("Enter your age:");
			int age = scanner.nextInt();

			if (age < 12) {
				bill += 5;
			} else if (age >= 12 && age < 18) {
				bill += 7;
			} else if (age >= 45 && age >= 55) {
				bill += 0;
			} else {
				bill += 12;
			}

			System.out.println("Do you want image photos");
			boolean isPhotos = scanner.nextBoolean();
			if (isPhotos)
				bill += 3;

			System.out.println("Your ride bill is: " + bill);

		}

	}

}
