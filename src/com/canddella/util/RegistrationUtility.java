package com.canddella.util;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.canddella.dao.RegistrationDAOImpl;
import com.canddella.entity.Customer;
import com.canddella.entity.Pet;
import com.canddella.entity.Registration;
import com.canddella.service.RegistrationServiceImpl;

public class RegistrationUtility {

	public static void main(String[] args) {

		findById();
		updateRegistration();
		getAllRegistration();
		insertIntoRegistration();

	}

	private static void findById() {
		getAllRegistration();
		
		Scanner scanner = new Scanner(System.in);
	

		System.out.println("Enter the Registration Id to find: ");
		int regId = scanner.nextInt();
		
		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();
		Registration registration=registrationServiceImpl.findById(regId);		
		
		System.out.println("********************************************");
		System.out.println("****************- Customer Details By ID-*******************");
		System.out.println("Registration ID : "+registration.getRegId());
		System.out.println("Customer ID : "+registration.getCustomer().getCustomerId());
		System.out.println("Pet ID : "+registration.getPet().getPetId());
		System.out.println("Registration Date : "+registration.getDate());
		System.out.println("Registration Time : "+registration.getTime());
		
		System.out.println("********************************************");
		
	}

	public static void updateRegistration() {
		getAllRegistration();

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Update Registration***********************");

		System.out.println("Enter the Registration Id to Update: ");
		int registrId = scanner.nextInt();

		RegistrationServiceImpl Registration = new RegistrationServiceImpl();
		Registration.updateById(registrId);

		getAllRegistration();

	}

	/***
	 * To get values from Registration table
	 */

	public static void getAllRegistration() {

		RegistrationDAOImpl registrationDAOImpl = new RegistrationDAOImpl();
		List<Registration> RegistrationList = registrationDAOImpl.findAll();
		System.out.println();
		System.out.println("\t" + "****************");
		System.out.println("\t" + "Registration DETAILS");
		System.out.println("\t" + "****************");

		System.out
				.println("Registration Id" + "\t" + "Customer Id" + "\t" + "Pet Id" + "\t" + "Date" + "\t\t" + "Time");
		System.out.println(
				"__________________________________________________________________________________________________________");
		for (Registration registration : RegistrationList) {
			System.out.println(registration.getRegId() + "\t\t" + registration.getCustomer().getCustomerId() + "\t\t"
					+ registration.getPet().getPetId() + "\t" + registration.getDate() + "\t" + registration.getTime());

			System.out.println(
					"_______________________________________________________________________________________________________");
			System.out.println();
			System.out.println();
		}

	}

	/***
	 * To insert values to the Registration table
	 */
	public static void insertIntoRegistration() {

		CustomerUtility.getAllCustomer();
		PetUtility.getAllPet();

		Scanner scanner = new Scanner(System.in);

		System.out.println("********************* Inserting into Registration ***********************");
		System.out.println("Enter the Customer Id:");
		int customerId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Pet Id:");
		int petId = scanner.nextInt();
		scanner.nextLine();

		/*
		 * System.out.println("Enter the Pet Name:"); String petName =
		 * scanner.nextLine();
		 */

		Pet pet = new Pet();// Setting pet id to pet
		Customer customer = new Customer();// Setting customer id to pet
		Registration reg = new Registration();

		customer.setCustomerId(customerId);
		pet.setPetId(petId);

		reg.setCustomer(customer);
		reg.setPet(pet);
		reg.setDate(new Date());

		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();
		registrationServiceImpl.save(reg);

		getAllRegistration();
	}

	public static void menu() {
		int subInput6;
		do {
			
		System.out.println();
		System.out.println("1.Add Service Registration");
		System.out.println("2.Update Service Registration");
		System.out.println("3.View All Service Registrations");
		System.out.println("4.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		Scanner scanner = new Scanner(System.in);
		subInput6 = scanner.nextInt();
		//boolean condition=true;
		
		switch(subInput6) {
		
		case 1:
			insertIntoRegistration();
			System.out.println();
			break;
		case 2:
			updateRegistration();
			System.out.println();
			break;
		case 3:
			getAllRegistration();
			System.out.println();
			break;
		case 4:
			System.out.println("*************************************************");
			
			
			break;
		default:
			System.out.println("Invalid Choice");
		
		}
		
		}while(subInput6 <= 3);
	}

}
