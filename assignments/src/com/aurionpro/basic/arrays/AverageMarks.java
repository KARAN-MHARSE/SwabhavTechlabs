package com.aurionpro.basic.arrays;

import java.util.Scanner;

public class AverageMarks {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size = scanner.nextInt();

		int[] marks = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the marks of " + (int)(i+1) + " student");
			marks[i] = scanner.nextInt();
		}

		int average = findAverageMarks(marks);

		System.out.println("The average marks of the whole class is " + average);

	}

	private static int findAverageMarks(int[] marks) {
		int totalMarks = 0;

		for (int mark : marks) {
			totalMarks += mark;
		}
		return totalMarks / marks.length;
	}
}
