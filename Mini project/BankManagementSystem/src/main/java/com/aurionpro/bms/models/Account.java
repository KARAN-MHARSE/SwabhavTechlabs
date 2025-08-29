package com.aurionpro.bms.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.AccountType;

public class Account {
	private int id;
	private int userId;
	private String accountNumber;
	private AccountType type;
	private double balance;
	private AccountStatus accountStatus;
	private Timestamp createdAt;

	// Constructors
	public Account() {
	}

	public Account(int id, int userId, String accountNumber, AccountType type, double balance, AccountStatus accountStatus,
			Timestamp createdAt) {
		this.id = id;
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.type = type;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	// toString
	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", userId=" + userId + ", accountNumber='" + accountNumber + '\'' + ", type='"
				+ type + '\'' + ", balance=" + balance + ", createdAt=" + createdAt + '}';
	}
}
