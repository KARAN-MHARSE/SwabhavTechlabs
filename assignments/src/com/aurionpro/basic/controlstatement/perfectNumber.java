package com.aurionpro.basic.controlstatement;

public class perfectNumber {
	private static boolean checkPerfectNumber(int number) {
		int sum = 0;
		
		for(int i=1;i<number;i++) {
			if(number % i == 0) {
				sum += i;
			}
		}
		return number == sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 5;
		
		boolean isPerfectNumber = checkPerfectNumber(number);
		if(isPerfectNumber) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}
