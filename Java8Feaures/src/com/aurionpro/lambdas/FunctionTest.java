package com.aurionpro.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		Function<Integer, Integer> calculateFactorial = (x)->{
			int ans = 1;
			for(int i=2;i<=x;i++) {
				ans*=i;
			}
			return ans;
		};
		
		System.out.println(calculateFactorial.apply(5));
		
		BiFunction<Integer, Integer, Integer> findMaxValue=(number1, number2)-> {
			if(number1>number2) return number1;
			return number2;
		};
		
		System.out.println(findMaxValue.apply(10,20));

	}

}
