import java.util.Scanner;
import java.util.*;
public class MatrixTest {

	public static void main(String args[]) {
		int matrix[][] = new int[2][2];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello");
		saveValuesInMatrix(scanner, matrix);
		printMatrix(scanner,matrix);
	}

	private static void saveValuesInMatrix(Scanner scanner, int[][] matrix) {
		System.out.println("Enter values to matrix");
		
		for(int i=0;i<matrix.length;i++) {
			saveRowValues(scanner, matrix,i);
		}
		
	}

	private static void saveRowValues(Scanner scanner, int[][] matrix, int i) {
		for(int j=0;j<matrix[i].length;j++) {
			matrix[i][j] = scanner.nextInt();
		}		
	}
	
	private static void printMatrix(Scanner scanner, int[][] matrix) {
		System.out.println("The values of matrix are:");
		for(int i=0;i<matrix.length;i++) {
			printRowsValue(scanner,matrix,i);
		}
	}
	
	private static void printRowsValue(Scanner scanner, int[][] matrix, int row) {
		for(int column = 0 ; column < matrix[row].length;column++) {
			System.out.print(matrix[row][column]+ " ");
		}
		System.out.println();
	}
}
