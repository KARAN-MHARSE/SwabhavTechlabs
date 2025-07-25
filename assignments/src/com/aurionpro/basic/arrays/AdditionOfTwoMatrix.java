package com.aurionpro.basic.arrays;

import java.util.Scanner;

public class AdditionOfTwoMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of rows of matrix");
		int matrixRows = scanner.nextInt();

		System.out.println("Enter the number of colums of matrix");
		int matrixCols = scanner.nextInt();

		int[][] matrix1 = new int[matrixRows][matrixCols];
		createMatrix(scanner, matrix1, matrixRows, matrixCols);

		System.out.println("Enter the coordintaes of the matrix 2");
		int[][] matrix2 = new int[matrixRows][matrixCols];
		createMatrix(scanner, matrix2, matrixRows, matrixCols);

		int[][] sumMatrix = new int[matrixRows][matrixCols];
		sumOfArray(matrix1, matrix2,sumMatrix);
		

		printSumOfMatrix(sumMatrix);

	}

	private static void printSumOfMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][i] + "  ");
			}
			System.out.println();

		}

	}

	private static void sumOfArray(int[][] matrix1, int[][] matrix2,int[][] sumMatrix) {
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}

	}

	private static void createMatrix(Scanner scanner, int[][] matrix, int matrixRows, int matrixCols) {
		for (int i = 0; i < matrixRows; i++) {
			for (int j = 0; j < matrixCols; j++) {
				System.out.println("Enter the " + i + " row and " + j + " column index element");
				int number = scanner.nextInt();
				matrix[i][j] = number;
			}
		}

	}

}
