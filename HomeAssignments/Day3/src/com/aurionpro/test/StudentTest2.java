package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest2 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Student[] students = new Student[3];
		
		createStudents(scanner,students);
		displayStudents(students);
		
		sortStudentsArray(students);
		System.out.println("After sorted by age");
		displayStudents(students);
	}

	private static void displayStudents(Student[] students) {
		for(Student student : students) {
			System.out.println(student);
		}
		
	}

	private static void createStudents(Scanner scanner, Student[] students) {
		System.out.println("Hii, Let's go");
		
		for(int i=0;i<students.length;i++) {
			System.out.println("Enter the name of student");
			String studentName = scanner.nextLine();
			
			System.out.println("Enter the roll number of student");
			String rollNumber = scanner.nextLine();
			
			System.out.println("Enter the age of student");
			int age = scanner.nextInt();
			scanner.nextLine();
			
			students[i] = new Student(studentName,rollNumber,age);
		}
		System.out.println("Thank You");
	}
	
	private static void sortStudentsArray(Student[] students) {
		for(int i=0;i<students.length-1;i++) {
			for(int j=i+1;j<students.length;j++) {
				
				if(students[i].getAge() > students[j].getAge()) {
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
					
				}
			}
		}
	}
}
