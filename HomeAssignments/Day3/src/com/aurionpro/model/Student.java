package com.aurionpro.model;

import java.util.Arrays;

public class Student {
	private String studentName;
	private String rollNumber;
	private int[] marks;
	private int age;
	

	public Student() {
	}
	
	public Student(String studentName,String rollNumber,int age) {
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.age = age;
	}

	public Student(String studentName, String rollNumber, int[] marks) {
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public double calculateAverage() {
		if (marks == null || marks.length == 0) return 0;
		
		double totalMarks = 0;
		for (int mark : marks) {
			totalMarks += mark;
		}
		return totalMarks / (marks.length);
	}

	public String calculateGrade() {
		int average = (int)calculateAverage();
		if (average >= 90) {
			return "A+";
		} else if (average >= 80) {
			return "A";
		} else if (average >= 70) {
			return "B";
		} else if (average >= 60) {
			return "C";
		} else if (average >= 50) {
			return "D";
		} else {
			return "Fail";
		}
	}

	public void printMarks() {
		System.out.print("[");
		for(int i=0;i<marks.length;i++) {
			if(i==marks.length-1) {
				System.out.print(marks[i]);
			}else {
				System.out.print(marks[i]+",");
			}
		}
		System.out.print("]");
		System.out.println();
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", rollNumber=" + rollNumber + ", age="
				+ age + "]";
	}

	public void printReport() {
		double average = calculateAverage();
		String grade = calculateGrade();

		System.out.println("Student Report Card");
		System.out.println("-------------------");
		System.out.println("Name    :" + studentName);
		System.out.println("Roll No :" + rollNumber);

		System.out.print("Marks   :");
		printMarks();
		System.out.println("Average :" + average);
		System.out.println("Grade   :" + grade);

	}

}
