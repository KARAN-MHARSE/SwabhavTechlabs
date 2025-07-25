package com.aurionpro.lambdas;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String args[]) {
		Supplier<ArrayList<Integer>> zeroToHundread = ()->{
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			int count =0;
			for(int i=0;i<100;i++) {
				arrayList.add(i+1);
			}
			return arrayList;
		};
		
		zeroToHundread.get().forEach(number->System.out.println(number));
		
		
	}
	

}
