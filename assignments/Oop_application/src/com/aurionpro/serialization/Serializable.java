package com.aurionpro.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializable {

	public static void main(String[] args) {
		Student student = new Student(230, "Karan Mharse");
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\karan.mharse\\Desktop\\output.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(student);
			
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Done");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
