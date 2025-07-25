package com.aurionrpo.builder;

class Food {
	private int id;
	private String name;
	private int price;

	private Food(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.price = builder.price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public static class Builder{
		private int id;
		private String name;
		private int price;
		
		
		public Builder() {
			
		}
		
		public Food build() {
			return new Food(this);
		}
		
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}
		
		
	}
	
}

public class Main {
	public static void main(String args[]) {
		Food food = new Food.Builder()
				.setId(1)
				.setName("Biryani")
				.setPrice(500)
				.build();
		
		System.out.println(food);
		
	}
	
}
