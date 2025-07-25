package com.aurionrpo.proxy;

import java.util.Scanner;

public class AtmProxy implements IBankAccount {
	Scanner scanner = new Scanner(System.in);
	private IBankAccount account;
	private final int pin = 1234;

	public AtmProxy(String name, double balance) {
		account = new RealBankAccount(name, balance);
	}

	@Override
	public void deposit(double amount) {
		account.deposit(amount);

	}

	@Override
	public void withdraw(double amount) {

		System.out.println("Enter the atm pin");
		int userPin = scanner.nextInt();
		scanner.nextLine();

		if (pin != userPin) {
			System.err.println("Wrong pin");
			return;
		}
		account.withdraw(amount);

	}

}
