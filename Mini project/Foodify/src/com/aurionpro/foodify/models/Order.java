package com.aurionpro.foodify.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.aurionpro.foodify.enumproperties.OrderStatus;

public class Order {
	private UUID id;
	private List<LineItem> lineItems;
	private Address orderLocation;
	private OrderStatus orderStatus;
	private LocalDate localDate;
	private UUID orderBy;

	public Order(UUID orderBy, List<LineItem> lineItems, Address orderLocation, OrderStatus orderStatus, LocalDate localDate) {
		this.id = UUID.randomUUID();
		this.orderBy = orderBy;
		this.lineItems = lineItems;
		this.orderLocation = orderLocation;
		this.orderStatus = orderStatus;
		this.localDate = localDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Address getOrderLocation() {
		return orderLocation;
	}

	public void setOrderLocation(Address orderLocation) {
		this.orderLocation = orderLocation;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	

	public void setOrderBy(UUID orderBy) {
		this.orderBy = orderBy;
	}

	public UUID getOrderBy() {
		return orderBy;
	}
	
	public double getTotalPrice() {
		double totalAmountBeforeDiscount =0;
		for(LineItem item : lineItems) {
			totalAmountBeforeDiscount += item.getOriginalLineItemPrice();
		}
		return totalAmountBeforeDiscount-getTotalDiscount();
	}
	
	public double getTotalDiscount() {
		double discount = 0;
		double totalAmountBeforeDiscount =0;
		for(LineItem item: lineItems) {
			discount+= item.getDiscountPrice();
			totalAmountBeforeDiscount+= item.getOriginalLineItemPrice();
		}
		if(totalAmountBeforeDiscount >= 500) {
			return discount+100;
		}
		return discount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", lineItems=" + lineItems + ", orderLocation=" + orderLocation + ", orderStatus="
				+ orderStatus + ", localDate=" + localDate + "]";
	}

}
