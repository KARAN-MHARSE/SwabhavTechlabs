package com.aurionpro.basic.controlstatement;

public class ReverseNumber {
	static int reverseANumber(int number) {
		int reverse = 0;
		while(number !=0 ) {
			reverse = reverse*10+(number%10);
			number= number/10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 153;
		
		int reverse = reverseANumber(number);
		System.out.println("The reverse of number "+ number + " is " + reverse);
	}

}
