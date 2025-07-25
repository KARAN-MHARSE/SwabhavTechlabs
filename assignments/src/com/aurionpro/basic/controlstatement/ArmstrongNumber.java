package com.aurionpro.basic.controlstatement;

public class ArmstrongNumber {

	private static boolean checkArmstrongNumber(int number) {
		int size = Integer.toString(number).length();
		int sum =0;
		int current= number;
		
		while(number != 0) {
			int digit = number % 10;
			sum += Math.pow(digit, size);
			number = number/10;
		}
		return current == sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 153;
		boolean isArmstrongNumber = checkArmstrongNumber(number);
		
		if(isArmstrongNumber ) {
			System.out.println("Yes given number is armstrong number");
		}else {
			System.out.println("No, given number is not armstrong number");
		}
	}

}
