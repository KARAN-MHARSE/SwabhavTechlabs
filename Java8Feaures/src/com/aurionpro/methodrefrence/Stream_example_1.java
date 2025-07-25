package com.aurionpro.methodrefrence;

import java.util.Arrays;
import java.util.List;

public class Stream_example_1 {
	public static void main(String args[]) {
		List<String> names = Arrays.asList("Nimesh", "Mark", "Mahesh", "Ajay","Ramesh");

		System.out.println("First three names of students in ascending order");
		names.stream()
			.sorted((name1, name2) -> name1.compareToIgnoreCase(name2))
			.limit(3)
			.forEach(System.out::println);

		System.out.println("\nFirst three names of students in ascending order if they contains a");
		names.stream()
			.filter(name -> name.indexOf('a') != -1 || name.indexOf('A') != -1)
			.sorted((name1, name2) -> name1.compareToIgnoreCase(name2))
			.limit(3)
			.forEach(System.out::println);

		System.out.println("\nprint names of students in descending order");
		names.stream()
			.sorted((name1, name2) -> name2.compareToIgnoreCase(name1))
			.forEach(System.out::println);

		System.out.println("\nprint first three characters of each student name");
		names.stream()
			.map(name -> name.substring(0, 3))
			.forEach(System.out::println);

		System.out.println("\nprint names of students whoes lenght is less than or equal to 4 charaters");
		names.stream()
			.filter(name -> name.length() <= 4)
			.forEach(System.out::println);

	}

}
