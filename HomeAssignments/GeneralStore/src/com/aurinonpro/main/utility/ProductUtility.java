package com.aurinonpro.main.utility;

import java.util.Map;

import com.aurinonpro.main.exceptions.ProductNotFountException;
import com.aurinonpro.main.models.Product;

public class ProductUtility {

	public static Product findProductById(Map<Integer, Product> products, int productId) {
		if (!products.containsKey(productId)) return null;
		return products.get(productId);
	}

	public static Product findProductByName(Map<Integer, Product> products, String productName) {
		Product product = null;
		for (Map.Entry<Integer, Product> entry : products.entrySet()) {
			if (entry.getValue().getProductName().equals(productName)) {
				product = entry.getValue();
			}
		}
		if (product == null) return null;
		return product;
	}
}
