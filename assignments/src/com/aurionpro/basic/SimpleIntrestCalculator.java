package com.aurionpro.basic;

import java.util.Scanner;

public class SimpleIntrestCalculator {
	
	private static double calculateSimpleIntrest(int principal, int time, float rateOfIntrest) {
		return (principal * rateOfIntrest * time)/100;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the principal ammount: ");
		int principal = scanner.nextInt();
		
		System.out.println("Enter the Time period in year: ");
		int time = scanner.nextInt();
		
		System.out.println("Enter the rate of intrest : ");
		float rateOfIntrest = scanner.nextFloat();
		
		double intrest = calculateSimpleIntrest(principal, time, rateOfIntrest);
		
		System.out.println("The Simple intrest for the given details is: "+ intrest);

	}

}
