package com.aurionpro.basic.controlstatement;

public class MaxOfTwoNumbers {
	private static void findMax(int number1,int number2) {
		if(number1<number2){
			System.out.println(number2);
		}
		else{
			System.out.println(number1);
		}
	}

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 8;
		
		findMax(number1,number2);

	}

}
