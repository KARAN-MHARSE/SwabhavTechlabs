package com.aurionpro.basic.arrays;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the numbers of " + (int)(i+1) + " student");
			numbers[i] = scanner.nextInt();
		}
		
		System.out.println("Array Before sorting:");
		printElemets(numbers);

		bubbleSort(numbers);

		System.out.println("Array after sorting:");
		printElemets(numbers);

	}

	private static void bubbleSort(int[] numbers) {
		int size = numbers.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

	}

	private static void printElemets(int[] numbers) {
		for (int number : numbers) {
			System.out.println(number);
		}

	}

}
