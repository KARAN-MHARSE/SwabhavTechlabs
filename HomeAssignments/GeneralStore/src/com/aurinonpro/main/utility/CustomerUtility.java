package com.aurinonpro.main.utility;

import java.util.List;
import java.util.Map;

import com.aurinonpro.main.exceptions.CustomerNotFoundException;
import com.aurinonpro.main.exceptions.OrderNotFoundException;
import com.aurinonpro.main.models.Customer;
import com.aurinonpro.main.models.Order;

public class CustomerUtility {

	public static Customer getCustomer(Map<Integer,Customer> customers, int customerId) {
		if(!customers.containsKey(customerId)) return null;
		return customers.get(customerId);	
	}
	
	public static List<Order> getAllOrders(Customer customer){
		if(customer.getOrders().isEmpty()) return null;
		return customer.getOrders();
	}
	
	public static Order getCurrentOrder(Customer customer) {
		for(Order order: customer.getOrders()) {
			if(!order.getIsCompleted()) return order;
		}
		return null;
	}

}
