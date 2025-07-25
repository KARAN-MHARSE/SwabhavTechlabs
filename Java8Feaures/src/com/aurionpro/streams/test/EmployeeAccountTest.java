//package com.aurionpro.streams.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.aurionpro.streams.model.EmployeeAccount;
//
//public class EmployeeAccountTest {
//
//	public static void main(String[] args) {
//		List<EmployeeAccount> accounts = new ArrayList<EmployeeAccount>();
////		loadInitialData(accounts);
//		
//		System.out.println("The list of employees:");
//		accounts.stream().forEach(System.out::println);
//		
//		System.out.println("\nThe employee having minimum balance is: ");
//		accounts.stream()
//			.min((account1,account2)-> (int)(account1.getSalary()-account2.getSalary()))
//			.ifPresent(System.out::println);
//		
//		System.out.println("\nThe employee having maximum balance is: ");
//		accounts.stream()
//			.max((account1,account2)-> (int)(account1.getSalary()-account2.getSalary()))
//			.ifPresent(System.out::println);
//		
//		System.out.println("\nThe employees whoes name is greater than 6 characters: ");
//		accounts.stream()
//			.filter(employee-> employee.getName().length() > 6)
//			.forEach(System.out::println);
//			
//		
//		System.out.print("\nThe total salary paid to all employees are: ");
//		double totalSalary = accounts.stream()
//			.map(EmployeeAccount::getSalary)
//			.reduce(0.0,(s1,s2)->s1+s2);
//		System.out.print(totalSalary);
//
//
//	}
//
////	private static void loadInitialData(List<EmployeeAccount> accounts) {
////		accounts.add(new EmployeeAccount("Vijay", 50000));
////		accounts.add(new EmployeeAccount("Narayan",60000));
////		accounts.add(new EmployeeAccount("Lakshmi",40000));
////		accounts.add(new EmployeeAccount("Taarak",90000));
////		accounts.add(new EmployeeAccount("Jethalal",150000));
////		accounts.add(new EmployeeAccount("Bhide",65000));
////		accounts.add(new EmployeeAccount("Sodhi",70000));
////		accounts.add(new EmployeeAccount("Bagha",30000));
////		accounts.add(new EmployeeAccount("Nattu Kaka",35000));
////		
////		
////	}
//
//}
