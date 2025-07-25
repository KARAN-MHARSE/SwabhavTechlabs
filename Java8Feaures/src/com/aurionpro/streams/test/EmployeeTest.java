package com.aurionpro.streams.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.streams.model.EmployeeAccount;

public class EmployeeTest {
	public static void main(String args[]) {
		List<EmployeeAccount> employees = new ArrayList<EmployeeAccount>(Arrays.asList(
				new EmployeeAccount("Prathamesh", "Patil", 50000), new EmployeeAccount("Jayesh", "Rawat", 60000),
				new EmployeeAccount("Akash", "Mharse", 20000), new EmployeeAccount("Satej", "Patwa", 90000),
				new EmployeeAccount("Shubham", "Chavan", 10000), new EmployeeAccount("Pravin", "Chaudhari", 75000),
				new EmployeeAccount("Akash", "Varma", 67000), new EmployeeAccount("Jatin", "Sharma", 40000),
				new EmployeeAccount("Vishwajeet", "Dube", 78000), new EmployeeAccount("Prathamesh", "Pawar", 40000)
		));
		
		
		System.out.println("Sorted employes by salary");
		employees.stream()
			.sorted((employee1,employee2)-> (int)(employee1.getSalary()-employee2.getSalary()))
			.forEach(System.out::println);
		
		System.out.println("Sorted employes by fname then lName");
//		employees.stream()
//			.sorted((emp1,emp2)->{
//				if((emp1.getSalary()-emp2.getSalary()) == 0) {
//			})
		
		employees.stream()
			.sorted(Comparator.comparing(EmployeeAccount::getFName).thenComparing(EmployeeAccount::getlName))
			.forEach(System.out::println);
	}

}
