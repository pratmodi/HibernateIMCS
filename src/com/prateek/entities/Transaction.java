package com.prateek.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@Column(name="id")
	static int id ;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	Account account;
	@Column(name="amount")
	double amount ;
	@Column(name="type")
	AccountType accountType;
	
	
	
	
	public Transaction(int id, Account account, double amount, AccountType accountType) {
		
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.accountType = accountType;
	}




	@Override
	public String toString() {
		return "Transaction [id=" + id + ", account=" + account + ", amount=" + amount + ", accountType=" + accountType
				+ "]";
	}




	public static int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Account getAccount() {
		return account;
	}




	public void setAccount(Account account) {
		this.account = account;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public AccountType getAccountType() {
		return accountType;
	}




	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	
}
