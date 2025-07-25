package com.aurionpro.methodrefrence;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Basic_stream_test {
	
	public static int doSqures(int number) {
		return number*number;
	}
	
	public static void main(String args[]) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		
//		numbers.stream().forEach(number->System.out.println(number));
//		numbers.stream().map(Basic_stream_test::doSqures).forEach(System.out::println);
		
		int totalSum = numbers.stream().reduce(0, (number1,number2)-> number1+number2);
		System.out.println("Total sum of list integers: "+totalSum);
		
		int totalEvenNumbers = (int) numbers.stream().filter(number->number%2==0).count();
		System.out.println("Total Even numbers: "+totalEvenNumbers);
		
		Optional<Integer> smallestNumber = numbers.stream().min((number1,number2)-> number1-number2);
		System.out.println("The smallest number in list is: "+smallestNumber.get());
		
		Optional<Integer> greatestNumber = numbers.stream().max((number1,number2)-> number1-number2);
		System.out.println("The largest number in list is: "+greatestNumber.get());
	}

}
