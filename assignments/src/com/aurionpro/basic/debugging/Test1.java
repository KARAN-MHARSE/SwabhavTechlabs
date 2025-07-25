package com.aurionpro.basic.debugging;

public class Test1 {

	public static void main(String[] args) {
		int number = 5;
		
		printEven(number);
		System.out.println("Bye");

	}

	private static void printEven(int number) {
		System.out.println("Welcome in printeven method");
		
		for(int i=0;i<number;i++) {
			if(i%2 == 0) {
				System.out.println("Even: "+ i);
			}
		}
		
	}

}
