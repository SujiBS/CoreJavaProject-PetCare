package com.canddella.entity;

public class Bill {

	private int billId;
	private Registration registration; // HAS A
	private double amount;
	private String paymentMode;
	public Bill() {
		super();
	}

	

	public Bill(int billId, Registration registration, double amount, String paymentMode) {
		super();
		this.billId = billId;
		this.registration = registration;
		this.amount = amount;
		this.paymentMode = paymentMode;
	}



	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getPaymentMode() {
		return paymentMode;
	}



	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

}
