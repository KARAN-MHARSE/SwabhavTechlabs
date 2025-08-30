package com.aurionpro.bms.services;

import java.util.List;

import com.aurionpro.bms.dao.TransactionDao;
import com.aurionpro.bms.dto.TransactionDto;
import com.aurionpro.bms.exceptions.InputValidatorException;
import com.aurionpro.bms.models.Transaction;
import com.aurionpro.bms.properties.TransactionStatus;

public class TransactionService {
	private final TransactionDao transactionDao;

	public TransactionService() {
		transactionDao = new TransactionDao();
	}

	public boolean transfer(Transaction transaction,String password) {
		if(password == null || password.isEmpty()) throw new InputValidatorException("Invalid password");
		if(transaction == null) throw new InputValidatorException("Invalid credentials");
		if(transaction.getAmount() <=0) throw new InputValidatorException("Amount should be greatter than 0");
		
		return transactionDao.transfer(transaction,password);
		
	}

	public List<TransactionDto> getAllTransaction(){
		return transactionDao.getAllTransaction();
		
	}

	public List<TransactionDto> getTransactionsByUserId(int userId){
		return transactionDao.getTransactionsByUserId(userId);
	}

	public List<TransactionDto> getTransactionsByStatus(TransactionStatus status){
		return transactionDao.getTransactionsByStatus(status);
	}
	
	public boolean credit(String accountNumber, double amount, String message) {
		if(accountNumber== null || accountNumber.isBlank()) throw new InputValidatorException("Invalid account number");
		if(amount <=0) throw new InputValidatorException("Amount should be greatter than 0");

		return transactionDao.creditAmount(accountNumber, amount, message);
	}
	public boolean debit(String accountNumber, double amount, String message) {
		if(accountNumber== null || accountNumber.isBlank()) throw new InputValidatorException("Invalid account number");
		if(amount <=0) throw new InputValidatorException("Amount should be greatter than 0");

		return transactionDao.debitAmount(accountNumber, amount, message);
	}

}
