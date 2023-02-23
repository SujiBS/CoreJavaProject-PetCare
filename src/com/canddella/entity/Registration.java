package com.canddella.entity;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;

public class Registration {

	private int regId;
	private Customer customer; //HAS A 
	private Pet pet; //HAS A 
	private Date date;
	private Time time;
	
	public Registration() {
		super();
	}

	public Registration(int regId, Customer customer, Pet pet, Date date, Time time2) {
		super();
		this.regId = regId;
		this.customer = customer;
		this.pet = pet;
		this.date = date;
		this.time = time2;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
