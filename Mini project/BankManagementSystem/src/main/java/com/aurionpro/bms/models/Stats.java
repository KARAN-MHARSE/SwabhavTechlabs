package com.aurionpro.bms.models;

public class Stats {
	private int totalCustomers;
	private int totalApprovedAccounts;
	private int totalPendingAccounts;
	private int totalSuccessTransaction;
	private int totalFailedTransaction;
	
	public Stats() {
		// TODO Auto-generated constructor stub
	}

	public Stats(int totalCustomers, int totalApprovedAccounts, int totalPendingAccounts, int totalSuccessTransaction,
			int totalFailedTransaction) {
		super();
		this.totalCustomers = totalCustomers;
		this.totalApprovedAccounts = totalApprovedAccounts;
		this.totalPendingAccounts = totalPendingAccounts;
		this.totalSuccessTransaction = totalSuccessTransaction;
		this.totalFailedTransaction = totalFailedTransaction;
	}

	public int getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public int getTotalApprovedAccounts() {
		return totalApprovedAccounts;
	}

	public void setTotalApprovedAccounts(int totalApprovedAccounts) {
		this.totalApprovedAccounts = totalApprovedAccounts;
	}

	public int getTotalPendingAccounts() {
		return totalPendingAccounts;
	}

	public void setTotalPendingAccounts(int totalPendingAccounts) {
		this.totalPendingAccounts = totalPendingAccounts;
	}

	public int getTotalSuccessTransaction() {
		return totalSuccessTransaction;
	}

	public void setTotalSuccessTransaction(int totalSuccessTransaction) {
		this.totalSuccessTransaction = totalSuccessTransaction;
	}

	public int getTotalFailedTransaction() {
		return totalFailedTransaction;
	}

	public void setTotalFailedTransaction(int totalFailedTransaction) {
		this.totalFailedTransaction = totalFailedTransaction;
	}

	@Override
	public String toString() {
		return "Stats [totalCustomers=" + totalCustomers + ", totalApprovedAccounts=" + totalApprovedAccounts
				+ ", totalPendingAccounts=" + totalPendingAccounts + ", totalSuccessTransaction="
				+ totalSuccessTransaction + ", totalFailedTransaction=" + totalFailedTransaction + "]";
	}
	
	
	

}
