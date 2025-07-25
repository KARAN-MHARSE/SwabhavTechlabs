package com.aurionpro.basic.controlstatement;

public class PalindromeNumber {

	static int reverseANumber(int number) {
		int reverse = 0;
		while(number !=0 ) {
			reverse = reverse*10+(number%10);
			number= number/10;
		}
		return reverse;
	}
	public static void main(String args[]) {
		int number = 11;
		int reverse = reverseANumber(number);
		if(reverse == number) {
			System.out.println("Yes number is palindrome");
		}
		else {
			System.out.println("No number is palindrome");
		}
	}
	
	
}
