package com.canddella.util;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Pet_Category;
import com.canddella.service.CustomerServiceImpl;
import com.canddella.service.Pet_CategoryServiceImpl;

public class Pet_CategoryUtility {

	public static void main(String[] args) {
		deleteFromPetCategory();
		findById();

		updatePet_Category();
		getAllPet_category();
		insertIntoPet_category();
		// getAllPet_category();

	}

	public static void deleteFromPetCategory() {
		getAllPet_category();

		Scanner scanner = new Scanner(System.in);

		System.out.println("**************** Delete From Pet Category ********************");
		System.out.println("Enter the Pet category Id to Delete: ");
		int petCate_Id = scanner.nextInt();

		Pet_Category pet_Category = new Pet_Category();

		pet_Category.setCategoryId(petCate_Id);

		Pet_CategoryServiceImpl pet_CategoryServiceImpl = new Pet_CategoryServiceImpl();
		pet_CategoryServiceImpl.deletePetCategoryById(pet_Category);

	}

	private static void findById() {
		getAllPet_category();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Pet category Id to find: ");
		int petCate_Id = scanner.nextInt();

		Pet_CategoryServiceImpl pet_CategoryServiceImpl = new Pet_CategoryServiceImpl();
		Pet_Category pet_Category = pet_CategoryServiceImpl.findById(petCate_Id);

		System.out.println("********************************************");
		System.out.println("****************- Customer Details By ID-*******************");
		System.out.println("Pet category ID : " + pet_Category.getCategoryId());
		System.out.println("Pet category Name : " + pet_Category.getCategoryName());

		System.out.println("********************************************");

	}

	public static void updatePet_Category() {

		getAllPet_category();

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Update Pet Category***********************");

		System.out.println("Enter the Pet_Category Id to Update: ");
		int categorytId = scanner.nextInt();

		Pet_CategoryServiceImpl pet_CategoryServiceImpl = new Pet_CategoryServiceImpl();
		pet_CategoryServiceImpl.updateById(categorytId);

		getAllPet_category();
	}

	public static void insertIntoPet_category() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Pet Category***********************");

		/*
		 * System.out.println("Enter Category ID:"); int categtId = scanner.nextInt();
		 * 
		 * scanner.nextLine();
		 */

		System.out.println("Enter Category Name:");
		String categName = scanner.nextLine();

		Pet_Category Pet_category = new Pet_Category(categName);
		Pet_CategoryServiceImpl pet_categoryService = new Pet_CategoryServiceImpl();
		pet_categoryService.save(Pet_category);

		getAllPet_category();
	}

	public static void getAllPet_category() {

		Pet_CategoryServiceImpl pet_CategoryServiceImpl = new Pet_CategoryServiceImpl();
		List<Pet_Category> Pet_CategoryList = pet_CategoryServiceImpl.findAll();
		System.out.println();
		System.out.println("\t" + "*************");
		System.out.println("\t" + "PET CATEGORY");
		System.out.println("\t" + "*************");

		System.out.println("Category Id" + "	" + "Category Name");
		System.out.println("________________________________");
		for (Pet_Category Pet_Category : Pet_CategoryList) {
			System.out.println(Pet_Category.getCategoryId() + "\t\t" + Pet_Category.getCategoryName());
			System.out.println("________________________________");
			System.out.println();
		}
	}

}
