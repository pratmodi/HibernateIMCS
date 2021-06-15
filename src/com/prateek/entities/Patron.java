package com.prateek.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patron")
public class Patron {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;
	@Column(name="image")
	byte[] image;
	
	
	
	public Patron() {
		
	}


	public Patron(int id, String name, byte[] ch) {
		
		this.id = id;
		this.name = name;
		this.image = ch;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}

