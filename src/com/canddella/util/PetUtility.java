package com.canddella.util;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;

import com.canddella.entity.Pet;
import com.canddella.entity.Pet_Category;
import com.canddella.service.CustomerServiceImpl;
import com.canddella.service.PetServiceImpl;

public class PetUtility {

	public static void main(String[] args) {
		findById();
		updatePet();
		getAllPet();
		insertIntoPet();
	}

	private static void findById() {
		getAllPet();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Pet Id to find: ");
		int petId = scanner.nextInt();

		PetServiceImpl petServiceImpl = new PetServiceImpl();
		Pet pet = petServiceImpl.findById(petId);

		System.out.println("********************************************");
		System.out.println("****************- Pet Details By ID-*******************");
		System.out.println("Pet ID : " + pet.getPetId());
		System.out.println("Pet ID : " + pet.getCustomer().getCustomerId());
		System.out.println("Pet ID : " + pet.getPetCategory().getCategoryId());
		System.out.println("Pet Name : " + pet.getPetName());
		System.out.println("Age : " + pet.getAge());
		System.out.println("Breed : " + pet.getBreed());
		System.out.println("Colour : " + pet.getColour());
		System.out.println("Gender : " + pet.getGender());
		System.out.println("Vaccination : " + pet.getVaccination());
		System.out.println("Disabilities : " + pet.getDisabilities());
		System.out.println("Weight : " + pet.getWeight());
		System.out.println("Height : " + pet.getHeight());
		System.out.println("********************************************");

	}

	/***
	 * To Update pet table
	 */
	public static void updatePet() {
		getAllPet();

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Update Pet***********************");

		System.out.println("Enter the Pet Id to Update: ");
		int petId = scanner.nextInt();

		PetServiceImpl petService = new PetServiceImpl();
		petService.updateById(petId);

		getAllPet();

	}

	/***
	 * To get values from pet table
	 */
	public static void getAllPet() {

		PetServiceImpl petServiceImpl = new PetServiceImpl();
		List<Pet> petList = petServiceImpl.findAll();
		System.out.println();
		System.out.println("\t" + "****************");
		System.out.println("\t" + "PET DETAILS");
		System.out.println("\t" + "****************");

		System.out.println("Pet Id" + "\t" + "Customer Id" + "\t" + "Category Id" + "\t" + "Pet Name" + "\t" + "Age"
				+ "\t" + "Colour" + "\t" + "Breed" + "\t\t" + "Gender" + "\t" + "Height" + "\t" + "weight" + "\t"
				+ "Vaccination" + "\t" + "Disabilities");
		System.out.println(
				"_______________________________________________________________________________________________________________________________________");
		for (Pet pet : petList) {
			System.out.println(pet.getPetId() + "\t\t" + pet.getCustomer().getCustomerId() + "\t\t"
					+ pet.getPetCategory().getCategoryId() + "\t" + pet.getPetName() + "\t\t" + pet.getAge() + "\t"
					+ pet.getColour() + "\t" + pet.getBreed() + "\t\t" + pet.getGender() + "\t" + pet.getHeight() + "\t"
					+ pet.getWeight() + "\t" + pet.getVaccination() + "\t" + pet.getDisabilities());

			System.out.println(
					"_____________________________________________________________________________________________________________________________________");
			System.out.println();
			System.out.println();
		}

	}

	/***
	 * To insert values to the pet table
	 */
	public static void insertIntoPet() {

		Pet_CategoryUtility.getAllPet_category();
		CustomerUtility.getAllCustomer();

		Scanner scanner = new Scanner(System.in);

		System.out.println("********************* Inserting into Pet ***********************");
		System.out.println("Enter the Customer Id:");
		int customerId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Pet Category Id:");
		int categoryId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Pet Name:");
		String petName = scanner.nextLine();

		System.out.println("Enter the Age of Pet:");
		int petAge = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Colour of Pet:");
		String petColour = scanner.nextLine();

		System.out.println("Enter the Gender of Pet:");
		String petgender = scanner.nextLine();

		System.out.println("Enter the Breed of Pet:");
		String petBreed = scanner.nextLine();

		System.out.println("Are You Completed All Vaccinations of the Pet ? :(Yes / No)");
		String vaccination = scanner.nextLine();

		System.out.println("Enter the Weight of Pet in Kg:");
		Double petWeight = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter the Height of Pet in cm:");
		Double petHeight = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Your Pet have any Disabilities ? :(Yes / No)");
		String disabilities = scanner.nextLine();

		Pet pet = new Pet();
		Customer customer = new Customer();// Setting customer id to pet
		Pet_Category petcategory = new Pet_Category();// Setting category id to pet

		customer.setCustomerId(customerId);
		petcategory.setCategoryId(categoryId);

		pet.setCustomer(customer);// **
		pet.setPetCategory(petcategory);// **

		pet.setPetName(petName);
		pet.setAge(petAge);
		pet.setColour(petColour);
		pet.setGender(petgender);
		pet.setBreed(petBreed);
		pet.setVaccination(vaccination);
		pet.setWeight(petWeight);
		pet.setHeight(petHeight);
		pet.setDisabilities(disabilities);

		PetServiceImpl petServiceImpl = new PetServiceImpl();
		petServiceImpl.save(pet);

		getAllPet();
	}

	public static void menu() {
		int subInput6;
		do {
			System.out.println();

			System.out.println("1.Add Pet");
			System.out.println("2.Update Pet");
			System.out.println("3.View All Pets");
			System.out.println("4.Go to Main Menu");

			System.out.println();
			System.out.println("Enter Your Choice : ");
			Scanner scanner = new Scanner(System.in);
			subInput6 = scanner.nextInt();

			switch (subInput6) {

			case 1:
				insertIntoPet();
				System.out.println();
				break;
			case 2:
				updatePet();
				System.out.println();
				break;
			case 3:
				getAllPet();
				System.out.println();
				break;
			case 4:
				System.out.println("*************************************************");
				

				break;
			default:
				System.out.println("Invalid Choice");

			}

		} while (subInput6 <= 3);
	}

}
