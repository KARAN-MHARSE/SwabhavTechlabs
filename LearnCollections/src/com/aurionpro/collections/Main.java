package com.aurionpro.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4,5,6,7,8,9));
		
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println("After retain");
		list1.retainAll(list2);
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println("remove even numbers");
		System.out.println(list2);
		list2.removeIf(num-> num%2==0);
		System.out.println(list2);
		
		System.out.println("Different methods to print list");
		System.out.println(list1);
		System.out.println();
		
		System.out.println("(1. Inhance loop)");
		for(int num:list1) {
			System.out.println(num);
		}
		System.out.println("(2. Iterator)");
		Iterator<Integer> iterator = list1.listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(list1.contains(4));
		
		
		Collections.sort(null);
		

	}

}
