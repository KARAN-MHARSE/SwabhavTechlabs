package com.aurionpro.basic.controlstatement;

public class FindEvenOdd {
	private static void checkEvenOdd(int number){
		if(number%2 ==0) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}

	public static void main(String[] args) {
		int number = 7;
		
		checkEvenOdd(number);
	}

}
