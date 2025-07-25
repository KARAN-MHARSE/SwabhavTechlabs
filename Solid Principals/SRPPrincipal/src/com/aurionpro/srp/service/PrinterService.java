package com.aurionpro.srp.service;

import com.aurionpro.srp.model.Invoice;

public class PrinterService {
	public static void printInvoice(Invoice invoice) {
		if(invoice == null) throw new RuntimeException("Invoice not found");
		double discount =InvoiceService.calculateDiscount(invoice);
		double tax = InvoiceService.calculateTax(invoice);
		double finalCost = InvoiceService.calculateFinalCost(invoice);
		
		
		System.out.println("Welcome to Digi Mart");
		System.out.println("Product Id: "+invoice.getId());
		System.out.println("Product Name: "+invoice.getProductName());
		System.out.println("Product Original Cost: "+invoice.getCost());
		System.out.println("Discount :"+discount);
		System.out.println("Total Tax: "+tax);
		System.out.println("Final Amount to pay: "+ finalCost);
	}

}
