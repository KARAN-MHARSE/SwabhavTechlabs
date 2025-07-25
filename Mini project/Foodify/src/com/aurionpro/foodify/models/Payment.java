package com.aurionpro.foodify.models;

import java.time.LocalDate;
import java.util.UUID;

import com.aurionpro.foodify.enumproperties.PaymentStatus;
import com.aurionpro.foodify.interfaces.IPaymentType;

public class Payment {
	private UUID id;
	private UUID orderBy;
	private UUID invoiceId;
	private double amount;
	private PaymentStatus paymentStatus;
	private IPaymentType paymentType;
	private LocalDate dateOfPayment;

	public Payment(UUID orderBy, UUID invoiceId, double amount, PaymentStatus paymentStatus, IPaymentType paymentType) {
		this.id = UUID.randomUUID();
		this.orderBy = orderBy;
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentType = paymentType;
		this.dateOfPayment = LocalDate.now();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(UUID orderBy) {
		this.orderBy = orderBy;
	}

	public UUID getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(UUID invoiceId) {
		this.invoiceId = invoiceId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public IPaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(IPaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderBy=" + orderBy + ", invoiceId=" + invoiceId + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + ", paymentType=" + paymentType + ", dateOfPayment="
				+ dateOfPayment + "]";
	}

	
}
