package com.aurionpro.basic;

import java.util.Scanner;

public class SwapNumbers {
	private static void display(int number1, int number2) {
		System.out.println("number1=" + number1);
		System.out.println("number2=" + number2);
	}
	public static  void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number1 value: ");
		int number1 = scanner.nextInt();

		System.out.println("Enter number2 value: ");
		int number2 = scanner.nextInt();

		
		number1 = number1 ^ number2;
		number2 = number1 ^ number2;
		number1 = number1 ^ number2;
		
		display(number1,number2);
		
	}

}
