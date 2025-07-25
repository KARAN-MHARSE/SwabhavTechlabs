package com.aurionpro.basic.controlstatement;

public class SwitchClass {

	public static void main(String[] args) {
		int x = 3;
		
		switch(x) {
		case 1:
			System.out.println("January");
			break;
			
		case 2:
			System.out.println("Feb");
			break;
			
		case 3:
		case 5:
			System.out.println("March");
			break;
			
		default:
			System.out.println("No matters");
			break;			
		}

	}

}
