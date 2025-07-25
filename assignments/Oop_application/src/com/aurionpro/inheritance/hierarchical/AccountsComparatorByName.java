package com.aurionpro.inheritance.hierarchical;

import java.util.Comparator;

public class AccountsComparatorByName implements Comparator<Account> {

	@Override
	public int compare(Account account1, Account account2) {
		return account1.getName().compareTo(account2.getName());
	}
}
