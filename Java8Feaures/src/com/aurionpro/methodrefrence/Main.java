package com.aurionpro.methodrefrence;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
	public static int factorialValue(int x) {
		int ans = 1;
		for(int i=2;i<=x;i++) ans*=i;
		return ans;
	}
	
	
	public static void printFa(Function<Integer,Integer> consumer) {
		System.out.println(consumer.apply(5));
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFa(Main::factorialValue);

	}

}
