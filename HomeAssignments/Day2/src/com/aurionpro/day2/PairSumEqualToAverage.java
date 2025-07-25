package com.aurionpro.day2;

import java.util.HashSet;
import java.util.Scanner;

public class PairSumEqualToAverage {
	private static int findAverage(int[] array, int size) {
		int sum = 0;

		for (int element : array) {
			sum += element;
		}
		return sum / size;
	}

	private static void findPairSumEqualToAverage(int[] array, int size) {
		int average = findAverage(array, size);
		HashSet<Integer> set = new HashSet<Integer>();

		for (int element : array) {
			int requiredElement = average - element;
			if (set.contains(requiredElement)) {
				System.out.println("The pair of numbers " + requiredElement + " and " + element
						+ " present in array whose sum equal to average " + average);
			} else {
				set.add(element);
			}
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of an array");
		int size = scanner.nextInt();

		int[] array = new int[size];

		System.out.println("Enter the elements of array");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}

		findPairSumEqualToAverage(array, size);

	}

}
