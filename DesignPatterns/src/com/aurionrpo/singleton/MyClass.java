package com.aurionrpo.singleton;

public class MyClass {
//	private static MyClass instance = new MyClass();
	private static MyClass instance = null;
	private static int count =0;

	private MyClass() {
		count++;
	}
	
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
	
	public void printSomething() {
		System.out.println("Hello " + count);
	}
	

}
