package com.aurionpro.model;

public class Account {

	private String accountNumber;
	private String name;
	private double balance;
	private AccountType accountType;
	private final double minimumAmmountBalance = 500;

	public Account() {
	}

	public Account(String accountNumber, String name, double balance, AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double deposit(double amount) {

		if ((balance + amount) < 500) {
			System.out.println("Enter ammount greatter than 500");
		} else {
			balance += amount;
		}
		return balance;
	}

	public boolean withdraw(double ammount) {
		if ((balance - ammount) < minimumAmmountBalance) {
			System.out.println("Sorry, your account dont have sufficient balance.");
			return false;
		} else {
			balance -= ammount;
			return true;
		}
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", accountType="
				+ accountType + "]";
	}

}
