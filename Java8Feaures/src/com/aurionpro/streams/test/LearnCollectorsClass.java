package com.aurionpro.streams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.aurionpro.streams.model.Product;


public class LearnCollectorsClass {
	public static void main(String args[]) {

		List<String> names = List.of("Alice", "Bob", "Alice");
		Set<String> namesSet = names.stream().collect(Collectors.toSet());

		Map<String, Integer> namesMap = names.stream()
				.collect(Collectors.toMap(name -> name, String::length, (e1, e2) -> e1));

//		Group by
		Map<Integer, List<String>> grouped = names.stream().collect(Collectors.groupingBy(String::length));

		grouped.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

//		PartitioningBy
		names.stream().collect(Collectors.partitioningBy(name -> name.length() < 4))
				.forEach((key, value) -> System.out.println(key + " => " + value));

		names.stream()
				.collect(Collectors.groupingBy(String::length,
						Collectors.mapping(name -> name.charAt(0), Collectors.toList())))
				.forEach((name, list) -> System.out.println(name + ":" + list));

//		Filtering in grouping
		names.stream().collect(Collectors.groupingBy(String::length,
				Collectors.filtering(name -> name.startsWith("A"), Collectors.toList())

		)).forEach((count, list) -> System.out.println(count + ":" + list));

		List<String> sentences = List.of("Hello world", "Java streams");
		sentences.stream()
		.map(sentence->sentence.split(" "))
		.forEach(System.out::println);
		
		sentences.stream()
			.flatMap(sentence->Arrays.stream(sentence.split(" ")))
			.forEach(System.out::println);
		
//		Task1
		System.out.println("\nTask1");
		List<String> phrases = List.of("hello world", "java rocks");
		phrases.stream()
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
//		Task2
		System.out.println("\nTask2");
		List<String> phrases1 = List.of("hi bo there", "good day");
		phrases1.stream()
			.flatMap(phrase->Arrays.stream(phrase.split(" ")))		
			.collect(Collectors.groupingBy(String::length))
			.forEach((size,list)->System.out.println(size+":"+list));

		
		
		
		
	}
}
