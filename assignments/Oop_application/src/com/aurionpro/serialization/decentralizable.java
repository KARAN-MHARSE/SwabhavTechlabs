package com.aurionpro.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class decentralizable {

	public static void main(String[] args) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\karan.mharse\\Desktop\\output.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			Student student = (Student)objectInputStream.readObject();
			System.out.println(student.getName());
			System.out.println(student.getRollNumber());
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		// TODO Auto-generated method stub

	}

}

// C:\Users\karan.mharse\Desktop\output.txt