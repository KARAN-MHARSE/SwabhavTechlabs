package com.aurionpro.inheritance.hierarchical;

import com.aurionpro.inheritance.hierarchical.exceptions.CustomException;

public class CurrentAccount extends Account{
	private  double overDraftLimit;


	public CurrentAccount( String name) {
		this(name,0,50000);
	}
	public CurrentAccount(String name, double balance) {
		this(name,balance,50000);
	}

	public CurrentAccount( String name, double balance,double overDraftLimit) {
		super(name,balance);
		this.overDraftLimit = overDraftLimit;
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public boolean debit(double amount) {
		if(amount <0) throw new CustomException("Amount should be greater than 0");
		if((getBalance()-amount) < -overDraftLimit) 
			throw new CustomException("Draft limit exceed");
		
		setBalance(getBalance()-amount);
		System.out.println("amount withdrawn successfully");
		return true;
	}
}
