package com.prateek.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
	@Column(name="id")
	int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bank_id")
	Bank bank;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="patron_id")
	Patron patron;
	
	
	
	
	public Account() {
		
	}


	public Account(int id, Bank bank, Patron patron) {
		
		this.id = id;
		this.bank = bank;
		this.patron = patron;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	public Patron getPatron() {
		return patron;
	}


	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
	
	
}
