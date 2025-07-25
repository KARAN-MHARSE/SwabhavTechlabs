package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
	public static Student createStudent(Scanner scanner) {
		int[] marks = new int[5];
		System.out.println("Enter the student name:");
		String studentName = scanner.nextLine();
		
		System.out.println("Enter the roll number");
		String rollNumber = scanner.nextLine();
		
		System.out.println("Enter the marks of student");
		for(int i=0;i<5;i++) {
			System.out.println("Enter the marks of "+(int)(i+1) + " subject:");
			marks[i] = scanner.nextInt();
		}
		scanner.nextLine();
		System.out.println("Thanks!");
		
		Student student = new Student(studentName,rollNumber,marks);
		return student;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Student student1 = createStudent(scanner);
//		student1.printReport();
		
//		Student student2 = createStudent(scanner);
		student1.printReport();
//		student2.printReport();

	}

}
