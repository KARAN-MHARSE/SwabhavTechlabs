package com.aurionpro.inheritance.hierarchical;

import java.io.Serializable;

import com.aurionpro.inheritance.hierarchical.exceptions.CustomException;
import com.aurionpro.serialization.example2.Employee;

public abstract class Account implements Serializable,Comparable<Account> {
	private static int count=0;
	private String accountNumber;
	private String name;
	private double balance;
	
	
	public Account() {
		System.out.println("Enter valid details");
	}
	
	public Account(String name, double balance) {
		super();
		count++;
		this.accountNumber = "TJSB0000"+count;
		this.name = name;
		this.balance = balance;
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
	
	
	public void creditAmount(double amount) {
		if(amount <=0) {
			throw new CustomException("Amount should be greater than 0");
		}
		balance+=amount;
		System.out.println("Amount Successfullycredited to account and current balance is "+balance);
	}
	
	public abstract boolean debit(double amount) ;
	
	public void printPassbook() {
		System.out.println("Account Number: "+ accountNumber +"\nName: "+name);
		if(balance <0 ) {
			System.out.println("You have overdraft limit of: "+ (double)(50000+balance));
			return;
		}
		System.out.println("Balance: "+balance);
	}
	
	@Override
	public int compareTo(Account account) {
		return this.accountNumber.compareTo(account.getAccountNumber());
//		return (int)( this.balance - account.getBalance());
	}

	@Override
	public String toString() {
		return "[accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
