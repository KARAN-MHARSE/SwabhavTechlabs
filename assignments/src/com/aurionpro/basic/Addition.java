package com.aurionpro.basic;

import java.util.Scanner;

public class Addition {
	static int add(int number1,int number2) {
		return number1+number2;
	}
		public static void main(String args[]) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter number1 value: ");
			int number1= scanner.nextInt();
			
			System.out.println("Enter number2 value: ");
			int number2= scanner.nextInt();
			
			int ans = add(number1,number2);
			System.out.println("Addition of "+ number1 + " and "+ number2 + " is " + ans);
			System.out.println(ans);
		}
}
