package com.aurinonpro.main.utility;

import java.util.List;

import com.aurinonpro.main.models.LineItem;
import com.aurinonpro.main.models.Order;
import com.aurinonpro.main.models.Product;

public class OrderUtitlity {
	public static List<LineItem> getAllLineItemsOfOrder(Order order){
		if(order.getLineItems().isEmpty()) return null;
		return order.getLineItems();		
	}
	
	public static LineItem getLineItemFromOrderByProductId(Order order,int productId) {
		for(LineItem lineItem: order.getLineItems()) {
			if(lineItem.getProduct().getProductId() == productId) return lineItem;
		}
		return null;
	}
}
