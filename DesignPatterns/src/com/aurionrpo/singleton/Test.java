package com.aurionrpo.singleton;

public class Test {
	public static void main(String[] args) {
		MyClass myClass = MyClass.getInstance();	
		myClass.printSomething();
		
		MyClass myClass2 = MyClass.getInstance();	
		myClass.printSomething();
	}
}
