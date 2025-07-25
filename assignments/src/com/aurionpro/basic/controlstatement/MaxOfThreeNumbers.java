package com.aurionpro.basic.controlstatement;

public class MaxOfThreeNumbers {
	public static void findMax(int number1,int number2, int number3) {
		if(number1 > number2 && number1 > number3) {
			System.out.println(number1);
		}
		else if(number2 > number1 && number2 > number3) {
			System.out.println(number2);
		}else {
			System.out.println(number3);
		}
	}
	public static void main(String args[]) {
		int number1 = 5;
		int number2 = 7;
		int number3 = 1;
		
		findMax(number1,number2,number3);
	}
}
