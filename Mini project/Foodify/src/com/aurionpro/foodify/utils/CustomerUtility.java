package com.aurionpro.foodify.utils;

import com.aurionpro.foodify.enumproperties.OrderStatus;
import com.aurionpro.foodify.models.Customer;
import com.aurionpro.foodify.models.Order;

public class CustomerUtility {

	public static Order getCurrentOrder(Customer customer) {
		if(customer.getOrders() == null ||customer.getOrders().isEmpty()) return null;
		
		for(Order order: customer.getOrders()) {
			if(order.getOrderStatus().equals(OrderStatus.Pending)) return order;
		}
		return null;
	}
}
