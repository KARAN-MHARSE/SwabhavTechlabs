package com.aurionpro.srp.service;

import com.aurionpro.srp.model.Invoice;

public class InvoiceService {

	public static double calculateTax(Invoice invoice) {
		if (invoice == null)
			throw new RuntimeException("Invoice not found");

		double discountedPrice = calculateDiscount(invoice);
		return discountedPrice * invoice.getCostTax() / 100;
	}

	public static double calculateDiscount(Invoice invoice) {
		if (invoice == null)
			throw new RuntimeException("Invoice not found");

		return invoice.getCost() * invoice.getDiscountPercentage() / 100;

	}
	
	public static double calculateFinalCost(Invoice invoice) {
		if(invoice == null ) throw new RuntimeException("Invoice not found");
		
		double discount = calculateDiscount(invoice);
		double tax = calculateTax(invoice);
		double discountedPrice = invoice.getCost()-discount;
		
		return discountedPrice+tax;
	}

}
