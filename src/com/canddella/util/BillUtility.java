package com.canddella.util;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Bill;

import com.canddella.entity.Registration;
import com.canddella.pdf.GenerateBill;
import com.canddella.service.BillServiceImpl;

public class BillUtility {

	public static void main(String[] args) {
		findById();
		updateBill();
		getAllBill();
		insertIntoBill();
	}
	
	private static void findById() {
		getAllBill();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Generate Bill***********************");

		System.out.println("Enter the Bill Id to find: ");
		int billId = scanner.nextInt();
		
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		Bill bill=billServiceImpl.generateBillById(billId);		
		
		System.out.println("********************************************");
		System.out.println("****************- BILL BY ID-*******************");
		System.out.println("Bill ID : "+bill.getBillId());
		System.out.println("Customer Name : "+bill.getRegistration().getCustomer().getCustomerName());
		System.out.println("Amount : "+bill.getAmount());
		System.out.println("Payment Mode : "+bill.getPaymentMode());
		
		System.out.println("********************************************");
	}

	public static void updateBill() {
		getAllBill();

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Update Bill***********************");

		System.out.println("Enter the Bill Id to Update: ");
		int billId = scanner.nextInt();

		BillServiceImpl billService = new BillServiceImpl();
		billService.updateById(billId);

		getAllBill();

	}

	/***
	 * To get values from Bill table
	 */
	public static void getAllBill() {

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		List<Bill> billList = billServiceImpl.findAll();
		System.out.println();
		System.out.println("\t" + "****************");
		System.out.println("\t" + "Bill DETAILS");
		System.out.println("\t" + "****************");

		System.out.println("Bill Id" + "\t\t" + "Registration Id" + "\t\t" + "Amount" + "\t\t" + "Payment Mode");
		System.out.println(
				"___________________________________________________________________________________________________________");
		for (Bill bill : billList) {
			System.out.println(bill.getBillId() + "\t\t" + bill.getRegistration().getRegId() + "\t\t\t"
					+ bill.getAmount() + "\t\t" + bill.getPaymentMode());

			System.out.println(
					"__________________________________________________________________________________________________________");
			System.out.println();
			System.out.println();
			/*
			 * BillServiceImpl billServiceImpl2 = new BillServiceImpl(); List<Bill>
			 * billListById = billServiceImpl2.printBill(bill.getBillId());
			 * printBill(billListById );
			 */
		}

	}

	/***
	 * To insert values to the Bill table
	 */

	public static void insertIntoBill() {

		RegistrationUtility.getAllRegistration();

		Scanner scanner = new Scanner(System.in);

		System.out.println("********************* Inserting into Bill ***********************");
		System.out.println("Enter the Registration Id:");
		int regId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Amount :");
		Double amount = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter the Payment Mode (Offline / Online) :");
		String mode = scanner.nextLine();

		Bill bill = new Bill();
		Registration registration = new Registration();// Setting customer id to pet

		registration.setRegId(regId);
		bill.setRegistration(registration);// **
		bill.setAmount(amount);
		bill.setPaymentMode(mode);

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		billServiceImpl.save(bill);

		getAllBill();

	}

	public static void menu() {
		int subInput6;
		do {
		System.out.println();
		System.out.println("1.Add Bill");
		System.out.println("2.Update Bill");
		System.out.println("3.View All Bills");
		System.out.println("4.Generate Bill");
		System.out.println("5.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		Scanner scanner = new Scanner(System.in);
		subInput6 = scanner.nextInt();
		
		switch(subInput6) {
		
		case 1:
			insertIntoBill();
			System.out.println();
			break;
		case 2:
			updateBill();
			System.out.println();
			break;
		case 3:
			getAllBill();
			System.out.println();
			break;
		case 4:
			GenerateBill.generateBillById();
		case 5:
			System.out.println("*************************************************");
		
			
			break;
		default:
			System.out.println("Invalid Choice");
		
		}
		
		}while(subInput6 <= 4);
	}

}
