package com.aurionpro.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String args[]) {
		Predicate<Integer> isEven = (number)-> number%2 ==0 ;
		System.out.println(isEven.test(10));
		
		BiPredicate<Integer, Integer> isFirstNumberGreatterThanSecond = (number1,number2)-> number1>number2;
		
		System.out.println(isFirstNumberGreatterThanSecond.test(10, 20));
		
		
	}

}
