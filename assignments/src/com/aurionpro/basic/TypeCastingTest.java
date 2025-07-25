package com.aurionpro.basic;

public class TypeCastingTest {

	public static void main(String[] args) {
//		double number = 18.77;
//		int number2 = (int)number;
		
//		int number1 = 10;
//		double number2 = number1;
//		System.out.println(number2);
		
//		byte number1 = 10;
//		byte number2 = (byte)(number1 +9);
//		System.out.println(number2);
		
//		byte number = 127;
//		System.out.println(number);
	
//		byte x = 10;
//		byte y = (byte)(x + 6);
//		System.out.println(y);
		
//		int a =10;
//		Integer obj = a;
//		System.out.println(obj.reverse());

	
		Integer number = Integer.valueOf("123");
		System.out.println(number);
		
		Integer number2 = Integer.parseInt("124");
		System.out.println(number2);
		
		Integer number3 = Integer.valueOf(10);
		String strNum = number.toString();
		System.out.println(strNum.getClass());
	}

}
