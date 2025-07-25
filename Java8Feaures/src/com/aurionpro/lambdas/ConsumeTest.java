package com.aurionpro.lambdas;

import java.text.BreakIterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumeTest {
	public static void main(String[] args) {
		System.out.println("Consumer");
		Consumer<Integer> findCircleArea = (radius)->System.out.println(3.14*radius*radius);
		BiConsumer<Integer, Integer> findRectangleArea = (length,breadth) -> System.out.println("Area of rectangle is: "+(int)(length*breadth));
		findCircleArea.accept(10);
		findRectangleArea.accept(10, 20);
		
	}

}
