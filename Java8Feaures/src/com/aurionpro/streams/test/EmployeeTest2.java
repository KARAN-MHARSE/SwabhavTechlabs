package com.aurionpro.streams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import com.aurionpro.streams.model.Employee;
import com.aurionpro.streams.model.EmployeeAccount;
import com.aurionpro.streams.model.Product;

public class EmployeeTest2 {
	public static void main(String args[]) {
		List<Employee> employees = new ArrayList<>(Arrays.asList(
			    new Employee("Prathamesh Patil", 50000, "HR"),
			    new Employee("Jayesh Rawat", 60000, "Finance"),
			    new Employee("Akash Mharse", 20000, "Tech"),
			    new Employee("Satej Patwa", 90000, "Tech"),
			    new Employee("Shubham Chavan", 10000, "HR"),
			    new Employee("Pravin Chaudhari", 75000, "Marketing"),
			    new Employee("Akash Varma", 67000, "Finance"),
			    new Employee("Jatin Sharma", 40000, "Sales"),
			    new Employee("Vishwajeet Dube", 78000, "Tech"),
			    new Employee("Prathamesh Pawar", 40000, "HR")
			));
		
//		System.out.println("Sorted employees");
//		employees.stream()
//			.sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
//			.forEach(System.out::println);
		
		System.out.println("Find highest paid employee in each dept");
		employees.stream()
			.sorted(Comparator.comparing(Employee::getDept).thenComparing(Employee::getSalary).reversed())
			.collect(Collectors.groupingBy(Employee::getDept))
			.forEach((dept,employee)->{
				System.out.println(employee.get(0));
				
			});
		
//		Print names in list of starting charactes list
		List<String>names = Arrays.asList("Apple","Banana","Ajhj","Cat","biui","ghdg","chgch");
		names.stream()
			.collect(Collectors.groupingBy((name)-> name.charAt(0)))
			.forEach((ch,nameList)-> System.out.println(ch+":"+nameList));
		
		
//		create map with key character and size of names which start with that char
		Map<Character,Long> countMap=names.stream()
			.collect(Collectors.groupingBy((name)->name.charAt(0),Collectors.counting()));
		
		countMap.entrySet().stream().forEach(System.out::println);
		
//		Print uniques words from list of strings
		List<String> phrases = Arrays.asList("Hello world","hello java","Strean Api");
		phrases.stream()
			.flatMap(phrase->Arrays.stream(phrase.split(" ")))
			.map(word->word.toLowerCase())
			.distinct()
			.forEach(System.out::println);
		
		
//		Calculate total bill
		List<Product> products = new ArrayList<com.aurionpro.streams.model.Product>(Arrays.asList(
				new Product("abc", 50,5),
				new Product("xyz",58,34),
				new Product("pqr",10,37)
				));
		
		double total = products.stream()
			.map(product-> product.getPrice()*product.getQuantity())
			.reduce(0.0,(p1,p2)->p1+p2);
		System.out.println(total);
		
		List<String> emails = Arrays.asList(
				"karan@gmail.com",
				"jamsjdj@xcbn.com",
				"jekjkfje@abc.in",
				"jayesh@gmail.com"
				);
		
		emails.stream()
			.map(email-> email.substring(email.indexOf('@')))
			.distinct()
			.forEach(System.out::println);
		
		
//		
	}

}
