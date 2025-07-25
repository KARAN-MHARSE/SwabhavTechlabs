package com.aurionpro.OCP.model;

import java.net.InterfaceAddress;

import com.aurionpro.OCP.FestivalType;
import com.aurionpro.OCP.IFestival;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private IFestival festival;

	public FixedDeposit(int accountNumber, String name, double principal, int duration, IFestival festival) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public IFestival getFestival() {
		return festival;
	}

	public void setFestival(IFestival festival) {
		this.festival = festival;
	}

	@Override
	public String toString() {
		return "FixedDeposit [accountNumber=" + accountNumber + ", name=" + name + ", principal=" + principal
				+ ", duration=" + duration + ", festival=" + festival + "]";
	}

	public double getIntrestRate() {
		return festival.getIntrestRate();
		
	}
	
	public double calculateSimpleIntrest() {
		return principal*getIntrestRate()*duration/100;
	}
	
	

}
