package com.aurionpro.bms.dto;

import java.sql.Timestamp;

import com.aurionpro.bms.properties.TransactionStatus;

public class TransactionDto {
	private int transactionId;
	private String fromAccountNumber;
	private String receiverName;
	private String toAccountNumber;
	private String senderName;
	private double amount;
	private String message;
	private TransactionStatus status;
	private Timestamp createdAt;

	public TransactionDto() {
		super();
	}

	public TransactionDto(int transactionId, String fromAccountNumber, String receiverName, String toAccountNumber,
			String senderName, double amount, String message, TransactionStatus status, Timestamp createdAt) {
		super();
		this.transactionId = transactionId;
		this.fromAccountNumber = fromAccountNumber;
		this.receiverName = receiverName;
		this.toAccountNumber = toAccountNumber;
		this.senderName = senderName;
		this.amount = amount;
		this.message = message;
		this.status = status;
		this.createdAt = createdAt;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "TransactionDto [transactionId=" + transactionId + ", fromAccountNumber=" + fromAccountNumber
				+ ", receiverName=" + receiverName + ", toAccountNumber=" + toAccountNumber + ", senderName="
				+ senderName + ", amount=" + amount + ", message=" + message + ", status=" + status + ", createdAt="
				+ createdAt + "]";
	}

}
