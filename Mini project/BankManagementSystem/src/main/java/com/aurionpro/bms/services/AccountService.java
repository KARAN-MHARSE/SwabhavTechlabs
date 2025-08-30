package com.aurionpro.bms.services;

import java.sql.SQLException;
import java.util.List;

import com.aurionpro.bms.dao.AccountDao;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.exceptions.InputValidatorException;
import com.aurionpro.bms.models.Account;
import com.aurionpro.bms.models.Document;
import com.aurionpro.bms.models.Stats;
import com.aurionpro.bms.properties.AccountType;

public class AccountService {
	private final AccountDao accountDao;

	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public List<Account> getAccountsByUserId(int userId) {
		return accountDao.getAccountsByUserId(userId);
	}

	public boolean requestForNewAccount(int userId, Long adharNo, String panNo, AccountType accountType,
			List<Document> documents) {
		return accountDao.requestForNewAccount(userId, adharNo, panNo, accountType, documents);

	}
	public boolean createNewUserAccount(UserAccountDTO userAccountDTO) {
		return accountDao.createNewUserAccount(userAccountDTO);
	}
	
	public boolean approvedOrRejectPendingAccount(String accountNumber,boolean isApproved) {
		return accountDao.approvedOrRejectPendingAccount(accountNumber, isApproved);
	}
	
	public List<UserAccountDTO> getAllUserAccounts(){
		return accountDao.getAllUserAccounts();
	}
	
	public UserAccountDTO getUserAccountDetailsByAccountNumber(String accountNumber) {
		if(accountNumber == null || accountNumber.isBlank()) throw new InputValidatorException("Invalid account number");
		return accountDao.getUserAccountDetailsByAccountNumber(accountNumber);
	}
	
	public UserAccountDTO getUserAccountDetailsByUserId(int userId) {
		return accountDao.getUserAccountDetailsByUserId(userId);
	}
	public boolean blockAccount(String accountNumber,String status) {
		if(accountNumber == null || accountNumber.isEmpty()) {
			throw new InputValidatorException("Invalid account number");
		}
		return accountDao.blockAccount( accountNumber, status);
	}
	
	public Stats getStats() throws SQLException {
		return accountDao.getStats();
	}
	
	
}
