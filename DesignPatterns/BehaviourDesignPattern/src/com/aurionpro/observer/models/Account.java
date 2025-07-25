package com.aurionpro.observer.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.aurionpro.observer.enums.NotificationType;
import com.aurionpro.observer.repo.INotifier;

public class Account {
	private UUID accountNumber;
	private String name;
	private double balance;
	private List<INotifier> notifcationWays = new ArrayList<INotifier>();

	
	
	public Account(String name, double balance,List<INotifier> notifcationWays) {
		this.accountNumber = UUID.randomUUID();
		this.name = name;
		this.balance = balance;
		if(notifcationWays == null) {
			this.notifcationWays = new ArrayList<INotifier>();
		}else {
			this.notifcationWays = notifcationWays;
		}
		
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
	
	public UUID getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(UUID accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<INotifier> getNotifcationWays() {
		return notifcationWays;
	}

	public void setNotifcationWays(List<INotifier> notifcationWays) {
		this.notifcationWays = notifcationWays;
	}

	public void credit(double amount) {
		if(balance <0) {
			throw new RuntimeException("Balance should be greatter than 0");
		}
		
		balance+=amount;
		
		notifcationWays.forEach(notifier->notifier.sendNotification(amount, NotificationType.Credit));
	}
	
	public void debit(double amount) {
		if(balance <0) 
			throw new RuntimeException("Balance should be greatter than 0");
		if(amount > balance)  throw new RuntimeException("Amount should be less than balance");
		balance -= amount;
		notifcationWays.forEach(notifier->notifier.sendNotification(amount, NotificationType.Debit));
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	public void addNotificationWay(INotifier notifier) {
		if(!notifcationWays.contains(notifier)) {
			System.err.println("Notification way already exist");
			return;
		}
		notifcationWays.add(notifier);
		System.out.println("Notification way added");
	}
	
	public void removeNotificationWay(INotifier notifier) {
		if(notifcationWays.contains(notifier)) {
			System.err.println("Notification way not exist");
			return;
		}
		notifcationWays.remove(notifier);
		System.out.println("Notification way removed");
	}
	
	

}
