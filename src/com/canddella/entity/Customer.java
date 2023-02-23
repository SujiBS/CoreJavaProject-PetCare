package com.canddella.entity;

public class Customer {

	private int customerId;
	private String customerName;
	private String emailId;
	private String phoneNumber;
	private int age;
	private String address;
	
	
	public Customer(int customerId, String customerName, String emailId, String phn_num, int age, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.phoneNumber = phn_num;
		this.age = age;
		this.address = address;
	}
	public Customer(String customerName, String emailId, String phoneNumber, int age, String address) {
		super();
		
		this.customerName = customerName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.address = address;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
