package com.aurionpro.foodify.utils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.aurionpro.foodify.enumproperties.OrderStatus;
import com.aurionpro.foodify.models.LineItem;
import com.aurionpro.foodify.models.Order;

public class OrderUtility {
	public static LineItem getLineItem(Order order, int foodItemId) {
		for(LineItem lineItem : order.getLineItems()) {
			if(foodItemId == (lineItem.getFoodItem().getId())) {
				return lineItem;
			}
		}
		return null;
	}
	
	public static List<Order> getProcessOrders(List<Order> orders) {
		if(orders == null || orders.isEmpty()) return null;
		
		return orders.stream()
				.filter(order -> order.getOrderStatus().equals(OrderStatus.Process))
				.collect(Collectors.toList());
	}
	
	public static Order getOrderById(List<Order> orders, UUID orderId) {
		if(orders == null || orders.isEmpty()) return null;
		
		return orders.stream()
				.filter(order -> order.getId().equals(orderId))
				.findFirst()
				.orElse(null);

	}
	
}
