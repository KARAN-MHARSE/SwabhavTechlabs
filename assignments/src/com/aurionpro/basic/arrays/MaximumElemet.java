package com.aurionpro.basic.arrays;

import java.util.Scanner;

public class MaximumElemet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size = scanner.nextInt();
		
		int[] marks = new int[size];
		
		for(int i=0;i<size;i++) {
			System.out.println("Enter the marks of "+  (int)(i+1) +" student");
			marks[i] = scanner.nextInt();
		}
		
		int topper = findMaximumMarks(marks);
		
		System.out.println("The maximum marks in the whole class is "+ topper);

	}

	private static int findMaximumMarks(int[] marks) {
		int maximumMarks = 0;
		for(int mark : marks) {
			if(mark > maximumMarks) {
				maximumMarks = mark;
			}
		}
		return maximumMarks;
	}

}
