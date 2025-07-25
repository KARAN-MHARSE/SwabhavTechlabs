package com.karan.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Karan {
	public static void main(String args) {

		ShoppingCart cart = new ShoppingCart();
		
		IItem chocolate = new Chocolate("Dark", 300);
		Hat hat = new Hat("ffjhj", "fdb", 1000, 1);
		
		IItem hatItem = new HatAdapter(hat);
		
		cart.addItemToCart(hatItem);
		cart.addItemToCart(chocolate);

		cart.displayCart();
	}

}
