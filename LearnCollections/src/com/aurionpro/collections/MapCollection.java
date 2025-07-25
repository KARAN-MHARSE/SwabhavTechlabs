package com.aurionpro.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapCollection {
	public static void main(String args[]) {
		Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
		
		employees.put(101,new Employee(101, "Prathamesh", "Sales"));
		employees.put(102, new Employee(102, "Karan", "IT"));
		
		Set<Map.Entry<Integer,Employee>> set=employees.entrySet();
		
		for(Map.Entry<Integer, Employee> entry: set) {
			System.out.println(entry.getKey() +" => "+entry.getValue());
		}
	}

}
