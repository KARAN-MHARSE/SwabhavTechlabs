package com.aurionpro.foodify.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer extends User {
	private List<Order> orders = new ArrayList<Order>();
	private List<Payment> paymentHistory = new ArrayList<Payment>();
	private List<Invoice> invoiceList = new ArrayList<Invoice>();

	public Customer(String name, Address adress, String email, Long mobileNumber, String password) {
		super(name, adress, email, mobileNumber, password);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

	public List<Payment> getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(List<Payment> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	@Override
	public String toString() {
		return "Customer [orders=" + orders + ", paymentHistory=" + paymentHistory + ", invoiceList=" + invoiceList
				+ "]";
	}


	
}
