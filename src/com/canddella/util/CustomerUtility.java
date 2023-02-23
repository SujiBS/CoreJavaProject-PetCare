package com.canddella.util;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;

import com.canddella.service.CustomerServiceImpl;

public class CustomerUtility {

	public static void main(String[] args) {
		menu();
		findById();
		getAllCustomer();
		//insertIntoCustomer();
		//getAllCustomer();
		
		insertIntoCustomer();
		updateCustomer();
	}
	

	private static void findById() {

		getAllCustomer();
		
		Scanner scanner = new Scanner(System.in);
	

		System.out.println("Enter the Customer Id to find: ");
		int custId = scanner.nextInt();
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		Customer customer=customerServiceImpl.findById(custId);		
		
		System.out.println("********************************************");
		System.out.println("****************- Customer Details By ID-*******************");
		System.out.println("Customer ID : "+customer.getCustomerId());
		System.out.println("Customer Name : "+customer.getCustomerName());
		System.out.println("Email Id"+customer.getEmailId());
		System.out.println("Phone Number"+customer.getPhoneNumber());
		System.out.println("Age"+customer.getAge());
		System.out.println("Address"+customer.getAddress());
		
		System.out.println("********************************************");
		
	}


	public static void updateCustomer() {
		
		getAllCustomer();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Update Customer***********************");
		
		System.out.println("Enter the Customer Id to Update: ");
		int custId = scanner.nextInt();
		
		
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.updateById(custId);
		
		getAllCustomer();
	}

	public static void insertIntoCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Customer***********************");
		
		System.out.println("Enter Customer Name:");
		String custName = scanner.nextLine();
		System.out.println("Enter Customer Email Id:");
		String email = scanner.nextLine();
		System.out.println("Enter Customer Phone Number:");
		String phn_num = scanner.nextLine();
		System.out.println("Enter Customer Age:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Customer Address:");
		String address = scanner.nextLine();

		Customer customer = new Customer(custName, email, phn_num, age, address);
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.save(customer);
		
		
		getAllCustomer();
	}

	public static void getAllCustomer() {

		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		List<Customer> customerList = customerServiceImpl.findAll();
		System.out.println();
		System.out.println("\t" + "****************");
		System.out.println("\t" + "CUSTOMER DETAILS");
		System.out.println("\t" + "****************");

		System.out.println("Customer Id" + "\t" + "Customer Name" + "\t" + "Email ID" + "\t" + "Phone Number" + "\t"
				+ "Age" + "\t" + "Address");
		System.out.println(
				"___________________________________________________________________________________________________");
		for (Customer customer : customerList) {
			System.out.println(customer.getCustomerId() + "\t\t" + customer.getCustomerName() + "\t\t"
					+ customer.getEmailId() + "\t" + customer.getPhoneNumber() + "\t" + customer.getAge() + "\t"
					+ customer.getAddress());
			System.out.println(
					"___________________________________________________________________________________________________");
			System.out.println();
			System.out.println();
		}
	}


	public static void menu() {
		int subInput6;
		do {
		System.out.println();
		System.out.println("1.Add Customer");
		System.out.println("2.Update Customer");
		System.out.println("3.View All Customer");
		System.out.println("4.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		Scanner scanner = new Scanner(System.in);
		 subInput6 = scanner.nextInt();
	
		
		switch(subInput6) {
		
		case 1:
			insertIntoCustomer();
			System.out.println();
			break;
		case 2:
			updateCustomer();
			System.out.println();
			break;
		case 3:
			getAllCustomer();
			System.out.println("\n");
			break;
		case 4:
			System.out.println("*************************************************");
			condition=false;
			System.out.println();
			break;
		default:
			System.out.println("Invalid Choice");
		
		}
		
		}while(subInput6 <= 3);
	}

}
