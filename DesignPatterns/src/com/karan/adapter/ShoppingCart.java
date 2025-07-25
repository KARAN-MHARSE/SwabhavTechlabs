package com.karan.adapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
private List<IItem> items ;

public ShoppingCart() {
	this.items = new ArrayList<IItem>();
}

public List<IItem> getItems() {
	return items;
}

public void setItems(List<IItem> items) {
	this.items = items;
}


public void addItemToCart(IItem item) {
	items.add(item);
}

public List<IItem> getCartItems() {
	return items;
}
public double getCartPrice() {
	double total =0;
	for(IItem item: items) {
		total += item.getItemPrice();
	}
	return (total);
}

public void displayCart() {
	items.forEach(System.out::println);
}




}
