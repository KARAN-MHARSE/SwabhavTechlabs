package com.aurionpro.basic.controlstatement;

import java.util.Calendar;

public class SumOfDigits {

	static int caculateSum(int number) {
		int sum =0;
		int current= number;
		
		while(number != 0) {
			int digit = number % 10;
			sum += digit;
			number = number/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int number = 121;
		int sum = caculateSum(number);
		System.out.println(sum);
				

	}

}
