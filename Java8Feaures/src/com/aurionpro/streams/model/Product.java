package com.aurionpro.streams.model;

public class Product {
	
		String name;
		double price;
		int quantity;
		
		
		public Product(String name, double price, int quantity) {
			super();
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}
		@Override
		public String toString() {
			return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	
}
