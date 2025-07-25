package com.aurinonpro.main.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
private int customerId;
private String customerName;
private List<Order> orders;
private static int count =0;



public Customer(String customerName) {
	this.customerId = 700+count;
	count++;
	this.customerName = customerName;
	this.orders = new ArrayList<>();
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public List<Order> getOrders() {
	return orders;
}
public void setOrders(List<Order> orders) {
	this.orders = orders;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", orders=" + orders + "]";
}


}
