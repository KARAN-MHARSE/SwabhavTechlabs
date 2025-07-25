package com.aurionpro.functionalinterface;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductService {
	private ArrayList<Product> products;

	public ProductService() {
		products = new ArrayList<Product>();
		products.add(new Product(1, "Asus Laptop", Category.Electronic,60000));
		products.add(new Product(2, "Levis black Jeans", Category.Clothing,2000));
		products.add(new Product(3, "Samsung TV", Category.HomeAppliance,36000));
		products.add(new Product(4, "Coding Books", Category.Stationary,4000));
		products.add(new Product(5, "HP Laptop", Category.Electronic,95000));
		products.add(new Product(6, "Zara polo tshirt", Category.Clothing,3400));
	}
	
	Predicate<Product> isElectronicProduct = (product)->product.getCategory()==Category.Electronic;
	
	Function<Product, Double> calulateProductPrice = (product) ->{
		if(isElectronicProduct.test(product)) {
			return product.getPrice()-(product.getPrice()*10/100);
		}
		return product.getPrice();
	};
	
	public Product getProductById(int id) {
		return products.stream().filter(product->product.getProductId()==id).findFirst().orElse(null);
	}
	
	public void getAllProducts () {
		products.forEach(System.out::println);
	}
	
	public void getProductPriceAfterDiscountById(Scanner scanner) {
		System.out.println("Enter the product id");
		int productId = scanner.nextInt();
		scanner.nextLine();
		
		Product product = getProductById(productId);
		if(product == null ) throw new RuntimeException("Product not found");
		System.out.println(calulateProductPrice.apply(product));
		
	}
	
	public void printOriginalAndDiscountPrice(Scanner scanner) {
		System.out.println("Enter the product id");
		int productId = scanner.nextInt();
		scanner.nextLine();
		
		Product product = getProductById(productId);
		if(product == null ) throw new RuntimeException("Product not found");
		
		if(!isElectronicProduct.test(product)) {
			System.out.println("OriginalPrice "+ product.getPrice());
			System.out.println("Discount Price "+ product.getPrice());
			return;
		}
		System.out.println("OriginalPrice "+ product.getPrice());
		System.out.println("Discount Price "+ (double)(product.getPrice()-(product.getPrice()*10/100)));
	}
	
}
