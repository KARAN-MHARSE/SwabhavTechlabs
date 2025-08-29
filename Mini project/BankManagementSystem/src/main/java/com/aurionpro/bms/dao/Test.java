package com.aurionpro.bms.dao;

import java.util.List;

import com.aurionpro.bms.dto.TransactionDto;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.models.Transaction;
import com.aurionpro.bms.properties.TransactionStatus;

public class Test {
	public static void main(String args[]) {
//		AccountDao accountDao = new AccountDao();
//		
//		System.out.println("All user accounts");		
//		List<UserAccountDTO> allUserAccouts = accountDao.getAllUserAccounts();
//		for(UserAccountDTO useracc : allUserAccouts) {
//			System.out.println(useracc);
//		}
//		
//		System.out.println("\nAccount by number");
//		UserAccountDTO useraccountByNumber = accountDao.getUserAccountDetailsByAccountNumber("TDCB0001");
//		System.out.println(useraccountByNumber);
//		
//		System.out.println("\nAccount by user id");
//		UserAccountDTO useraccountByID = accountDao.getUserAccountDetailsByUserId(6);
//		System.out.println(useraccountByID);
//		
//		System.out.println("\n Pending accounts");
//		List<UserAccountDTO> pendingAccounts = accountDao.getAllPendingAccounts();
//		for(UserAccountDTO dto : pendingAccounts) {
//			System.out.println(dto);
//		}
//		
//		System.out.println("Approved account");
//		boolean result = accountDao.approvedOrRejectPendingAccount("TDCB00069121.157983899178", true);
//		System.err.println(result);
		
		
		TransactionDao transactionDao = new TransactionDao();
//		Transaction transaction = new Transaction(0, "TDCB0001", "TDCB0002", 9000, "Trail", null, null);
//		boolean done = transactionDao.transfer(transaction);
//		System.out.println(done);
		
		List<TransactionDto> list = transactionDao.getAllTransaction();
		for(TransactionDto d : list) {
			System.out.println(d);
		}
		
	}

}
