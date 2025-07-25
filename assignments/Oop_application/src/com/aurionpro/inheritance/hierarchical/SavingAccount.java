package com.aurionpro.inheritance.hierarchical;

import com.aurionpro.inheritance.hierarchical.exceptions.CustomException;

public class SavingAccount extends Account {
	private double minimumBalance;

	public SavingAccount( String name) {
		this(name,0,500);
	}
	public SavingAccount(String name, double balance) {
		this(name,balance,500);
	}
	public SavingAccount( String name, double balance,double minumumBalance) {
		super(name,balance);
		this.minimumBalance = minumumBalance;
	}
	
	
	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	
	@Override
	public boolean debit(double amount) {
		if(amount <0) throw new CustomException("Amount should be greater than 0");

		if((getBalance()-amount) < minimumBalance) {
			throw new CustomException("Minimum balance reached");
		}
		setBalance(getBalance()-amount);
		System.out.println("amount withdrawn successfully");
		return true;
	}
	
}
