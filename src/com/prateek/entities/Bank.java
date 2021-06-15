package com.prateek.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	
	
	public Bank() {
		
	}

	public Bank(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
