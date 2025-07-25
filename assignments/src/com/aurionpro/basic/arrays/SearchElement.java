package com.aurionpro.basic.arrays;

import java.util.Scanner;

public class SearchElement {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the numbers of " + (int) (i + 1) + " student");
			numbers[i] = scanner.nextInt();
		}

		System.out.println("Enter the number you want to check in array");
		int forCheckingNumber = scanner.nextInt();

		checkElemntPresent(numbers, forCheckingNumber);

	}

	private static void checkElemntPresent(int[] numbers, int forCheckingNumber) {
		for (int number : numbers) {
			if (number == forCheckingNumber) {
				System.out.println("The Element present in the array");
				return;
			}
		}
		System.out.println("The element is not present in array");

	}
}
