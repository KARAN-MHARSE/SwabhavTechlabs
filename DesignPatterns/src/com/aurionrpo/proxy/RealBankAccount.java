package com.aurionrpo.proxy;

public class RealBankAccount implements IBankAccount {

	private String name;
	private double balance;

	public RealBankAccount(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return balance;
	}

	public void setAmount(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "RealBankAccount [name=" + name + ", amount=" + balance + "]";
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Amount succesfully credited");

	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance) {
			System.err.println("Amount should be less than bank balance");
			return;
		}
		balance -= amount;
		System.out.println("Amount succesfully debited");

	}

}
