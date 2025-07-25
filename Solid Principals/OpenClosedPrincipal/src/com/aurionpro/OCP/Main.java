package com.aurionpro.OCP;

import java.util.Scanner;

import com.aurionpro.OCP.model.FixedDeposit;



public class Main {
	public static void main(String args[]) {
		IFestival diwali = ()-> 8.5;
		
		IFestival holi = ()-> 7.5;
		
		FixedDeposit fixedDeposit = new FixedDeposit(101, "Karan", 10000, 5, holi);
		System.out.println("SI is: "+fixedDeposit.calculateSimpleIntrest());
	}
}
