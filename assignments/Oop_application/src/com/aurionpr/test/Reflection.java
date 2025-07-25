package com.aurionpr.test;

import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws ClassNotFoundException {
		Class mathClass = Class.forName("java.util.Random");

		System.out.println(mathClass.getSimpleName());

		for (Method method : mathClass.getMethods()) {
			System.out.println(method.getName() + "\t" + method.getParameterCount());
		}

	}

}
