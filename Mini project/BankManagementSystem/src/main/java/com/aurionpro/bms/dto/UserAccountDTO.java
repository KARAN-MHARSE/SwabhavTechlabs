package com.aurionpro.bms.dto;

import java.sql.Timestamp;
import java.util.List;

import com.aurionpro.bms.models.Account;
import com.aurionpro.bms.models.Document;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.Gender;

public class UserAccountDTO {
	private int userId;
	private String name;
	private String address;
	private Gender gender;
	private Long mobile;
	private Long adhar;
	private String pan;
	private String email;
	private AccountStatus accountStatus;

	private int accountId;
	private String accountNumber;
	private double balance;
	private boolean isApproved;
	private Timestamp createdAt;

	private List<Document> documents;

	public UserAccountDTO() {
		super();
	}

	public UserAccountDTO(User user, Account account) {
		this.userId = user.getId();
		this.name = user.getName();
		this.address = user.getAddress();
		this.gender = user.getGender();
		this.mobile = user.getMobile();
		this.adhar = user.getAdharNo();
		this.pan = user.getPanNo();
		this.email = user.getEmail();

		if (account != null) {
			this.accountId = account.getId();
			this.accountNumber = account.getAccountNumber();
			this.balance = account.getBalance();
			this.accountStatus = account.getAccountStatus();
			this.createdAt = account.getCreatedAt();
		}
	}

	public UserAccountDTO(User user, Account account, List<Document> documents) {
		this.userId = user.getId();
		this.name = user.getName();
		this.address = user.getAddress();
		this.gender = user.getGender();
		this.mobile = user.getMobile();
		this.adhar = user.getAdharNo();
		this.email = user.getEmail();

		if (account != null) {
			this.accountId = account.getId();
			this.accountNumber = account.getAccountNumber();
			this.balance = account.getBalance();
			this.accountStatus = account.getAccountStatus();
			this.createdAt = account.getCreatedAt();
		}

		if (documents != null) {
			this.documents = documents;
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}
	

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Long getAdhar() {
		return adhar;
	}

	public void setAdhar(Long adhar) {
		this.adhar = adhar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "UserAccountDTO [userId=" + userId + ", name=" + name + ", address=" + address + ", gender=" + gender
				+ ", mobile=" + mobile + ", adhar=" + adhar + ", email=" + email + ", isActive=" + accountStatus.toString()
				+ ", accountId=" + accountId + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", isApproved=" + isApproved + ", createdAt=" + createdAt + ", documents=" + documents + "]";
	}

}
