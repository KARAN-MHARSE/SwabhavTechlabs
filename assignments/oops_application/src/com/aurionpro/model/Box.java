package com.aurionpro.model;

import java.awt.HeadlessException;

public class Box {
	private int length;
	private int depth;
	private int width;
	
//	private Box() {
//		System.out.println("Default COnstructor");
//	}
	
	public Box() {
		System.out.println("Hello");
	}

	public Box(int length,int width,int depth) {
		this.length = length;
		this.width = width;
		this.depth = depth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getwidth() {
		return width;
	}

	public void setwidth(int width) {
		this.width = width;
	}
	
	public void display() {
		System.out.println("Length: "+length+", width "+width+", height: "+depth);
	}
	

}
