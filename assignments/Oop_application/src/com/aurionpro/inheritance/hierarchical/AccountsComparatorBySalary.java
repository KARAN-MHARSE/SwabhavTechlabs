package com.aurionpro.inheritance.hierarchical;

import java.util.Comparator;

public class AccountsComparatorBySalary implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) {
		return (int)(o1.getBalance()-o2.getBalance());
	}

}
