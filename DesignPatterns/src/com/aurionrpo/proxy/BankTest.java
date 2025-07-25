package com.aurionrpo.proxy;

public class BankTest {
public static void main(String args[]) {
	System.out.println("Hello");
	
	AtmProxy atmProxy = new AtmProxy("Karan", 15000);
	atmProxy.withdraw(0);
}
}
