package com.aurionpro.day2;

import java.util.Scanner;

public class SortedSquaresSet {

	private static void findSortedSquareOfSortedArray(int[] array, int size) {
		int PositiveIndex = 0;
		int negativeIndex = 0;
		while (array[PositiveIndex] < 0) {
			PositiveIndex++;
		}

		int[] squaredArray = new int[size];
		int currentIndex = 0;
		for (int i = PositiveIndex; i < size; i++) {
			if (negativeIndex == i)
				negativeIndex++;
			while (negativeIndex < i && Math.abs(array[negativeIndex]) <= array[i]) {
				squaredArray[currentIndex] = (int) Math.pow(array[negativeIndex], 2);
				currentIndex++;
				negativeIndex++;
			}
			squaredArray[currentIndex] = (int) Math.pow(array[i], 2);
//			System.out.println(Math.pow(negativeIndex, currentIndex));
			currentIndex++;
		}
		while (negativeIndex < PositiveIndex) {
			squaredArray[currentIndex] = (int) Math.pow(array[negativeIndex], 2);
			currentIndex++;
			negativeIndex++;
		}

		System.out.println("Array after all");
		printArrayElements(squaredArray);

	}
	
	

	private static void printArrayElements(int[] array) {
		for (int element : array) {
			System.out.println(element);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of the array:");
		int size = scanner.nextInt();

		int[] sortedArray = new int[size];

		System.out.println("Enter the elements of array in the sorted manner: ");
		for (int i = 0; i < size; i++) {
			sortedArray[i] = scanner.nextInt();
		}

		findSortedSquareOfSortedArray2(sortedArray, size);

	}
	
	private static void findSortedSquareOfSortedArray2(int[] sortedArray,int size) {
		int[] squaredArray = new int[size];
		
		int start = 0;
		int end = size-1;
		int current = size-1;
		
		while(start<=end) {
			int leftSideSquared = sortedArray[start] * sortedArray[start];
			int rightSideSquared = sortedArray[end] * sortedArray[end];
			
			if(leftSideSquared >= rightSideSquared) {
				squaredArray[current] = leftSideSquared;
				start++;
			}else {
				squaredArray[current] = rightSideSquared;
				end--;
			}
			current--;
		}
		printArrayElements(squaredArray);

	}

}
 