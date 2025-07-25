package com.aurionpro.model;

public class Rectangle {
	private int length;
	private static int breath;
	public Rectangle(int length, int breath) {
		System.out.println("Constructor of rectangle class");
		this.length = length;
		this.breath = breath;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreath() {
		return breath;
	}
	public void setBreath(int breath) {
		this.breath = breath;
	}
	
	public void increment() {
		breath++;
	}
	@Override
	public String toString() {
		return "Reactangle [length=" + length + ", breath=" + breath + "]";
	}
	{
		 System.out.println("inner block without");
	 }
	 static {
		System.out.println("inner block in rectangle class");
		
	}
	 
	
	
}
