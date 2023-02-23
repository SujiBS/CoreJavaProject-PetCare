package com.canddella.util;

import java.util.Scanner;

import com.canddella.pdf.GenerateBill;

public class MainMenuBar {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		header();
		LoginTest login = new LoginTest();
		boolean chk = login.checkLogin();
		int value;
		if (chk == true) {
			Pet_CategoryUtility pet_CategoryUtility = new Pet_CategoryUtility(); // object creation of class
			CustomerUtility customerUtility = new CustomerUtility();
			EmployeeUtility employeeUtility = new EmployeeUtility();
			PetUtility petUtility = new PetUtility();
			RegistrationUtility registrationUtility = new RegistrationUtility();
			BillUtility billUtility = new BillUtility();
			GenerateBill GenerateBill = new GenerateBill();

			boolean temp = true;
			// boolean checker = true;
			// int checker = 1;
			value = menu();
			do {
			

				switch (value) {
				case 1:

					int subInput6 = submenu6();

					do {
						switch (subInput6) {
						case 1:
							System.out.println("Add Employee");
							System.out.println("*********************");
							employeeUtility.insertIntoEmployee();
							subInput6 = submenu6();
							break;

						case 2:
							System.out.println("Update Employee");
							System.out.println("*********************");
							employeeUtility.updateEmployee();
							subInput6 = submenu6();
							break;
						case 3:
							System.out.println("View All Employees");
							System.out.println("*********************");

							employeeUtility.getAllEmployee();
							// subInput6 = 4;
							subInput6 = submenu6();
							break;
						case 4:
							System.out.println("Go to Main Menu");

							break;

						default:

							System.out.println("Enter a valid menu");

							break;
						}
					} while (subInput6 != 4);

					break;
				case 2:

					int subInput = submenu1();

					do {
						switch (subInput) {
						case 1:
							System.out.println("Customer Registration");
							System.out.println("*********************");
							customerUtility.insertIntoCustomer();
							subInput = submenu1();
							// value=1;
							break;

						case 2:
							System.out.println("Update Customer");
							System.out.println("*********************");
							customerUtility.updateCustomer();
							subInput = submenu1();

							break;
						case 3:
							System.out.println("View All Customer");
							System.out.println("*********************");

							customerUtility.getAllCustomer();
							subInput = submenu1();
							break;
						case 4:
							System.out.println("Go to Main Menu");
							// checker = false;
							// System.exit(subInput);
							break;

						default:

							System.out.println("Enter a valid menu");

							break;
						}
					} while (subInput != 4);

					break;
				case 3:

					int subInput2 = submenu2();

					do {
						switch (subInput2) {
						case 1:
							System.out.println("Pet Registration");
							System.out.println("*********************");
							petUtility.insertIntoPet();
							subInput2 = submenu2();
							break;

						case 2:
							System.out.println("Update Pet");
							System.out.println("*********************");
							petUtility.updatePet();
							subInput2 = submenu2();
							break;
						case 3:
							System.out.println("View All Pets");
							System.out.println("*********************");

							petUtility.getAllPet();
							subInput2 = submenu2();
							break;
						case 4:
							System.out.println("Add Pet Category");
							System.out.println("*********************");
							pet_CategoryUtility.insertIntoPet_category();
							subInput2 = submenu2();
							break;
						case 5:
							System.out.println("Update Pet Category");
							System.out.println("*********************");
							pet_CategoryUtility.updatePet_Category();
							subInput2 = submenu2();
							break;
						case 6:
							System.out.println("View All Pet Categories");
							System.out.println("*********************");

							pet_CategoryUtility.getAllPet_category();
							subInput2 = submenu2();
							break;
						case 7:
							System.out.println("Delete Pet Category By Id");
							System.out.println("*********************");

							pet_CategoryUtility.deleteFromPetCategory();
							subInput2 = submenu2();
							break;

						case 8:
							System.out.println("Go to Main Menu");

							break;

						default:

							System.out.println("Enter a valid menu");

							break;
						}
					} while (subInput2 != 8);

					break;
				case 4:

					int subInput3 = submenu3();

					do {
						switch (subInput3) {
						case 1:
							System.out.println("Service Registration");
							System.out.println("*********************");
							registrationUtility.insertIntoRegistration();
							subInput3 = submenu3();
							break;

						case 2:
							System.out.println("Update Service Registration");
							System.out.println("*********************");
							registrationUtility.updateRegistration();
							subInput3 = submenu3();
							break;
						case 3:
							System.out.println("View All Service Registrations");
							System.out.println("*********************");

							registrationUtility.getAllRegistration();
							subInput3 = submenu3();
							break;
						case 4:
							System.out.println("Go to Main Menu");

							break;

						default:

							System.out.println("Enter a valid menu");

							break;
						}
					} while (subInput3 != 4);

					break;

				case 5:

					int subInput4 = submenu4();

					do {
						switch (subInput4) {
						case 1:
							System.out.println("Bill Registration");
							System.out.println("*********************");
							billUtility.insertIntoBill();
							subInput4 = submenu4();
							break;

						case 2:
							System.out.println("Update Bill");
							System.out.println("*********************");
							billUtility.updateBill();
							subInput4 = submenu4();
							break;
						case 3:
							System.out.println("View All Bills");
							System.out.println("*********************");

							billUtility.getAllBill();
							subInput4 = submenu4();
							break;
						case 4:
							System.out.println("Generate Bills");
							System.out.println("*********************");

							GenerateBill.generateBillById();
							subInput4 = submenu4();
							break;
						case 5:
							System.out.println("Go to Main Menu");

							break;

						default:

							System.out.println("Enter a valid menu");

							break;
						}
					} while (subInput4 != 5);

					break;

				case 6:

					System.out.println("Log Out Successfully.... ");
					temp = false;
					// System.exit(value);
					break;

				default:

					System.out.println("Enter a valid menu");

					break;

				}
				System.out.println("##########################");
			} while (temp);
		}
		else {
			System.out.println("Do You Want to Continue ?(Y/N)");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("Y")) {
				chk=login.checkLogin();
				value =menu();
			} else {
				System.out.println("Exit !");
			}

		}

	}

	private static int submenu6() {
		System.out.println();
		System.out.println("1.Add Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.View All Employees");
		System.out.println("4.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		int subInput6 = scanner.nextInt();
		return subInput6;

	}

	/*
	 * private static int submenu5() { System.out.println();
	 * System.out.println("1.Add Pet Category");
	 * System.out.println("2.Update Pet Category");
	 * System.out.println("3.View All Pet Categories");
	 * System.out.println("4.Go to Main Menu");
	 * 
	 * System.out.println(); System.out.println("Enter Your Choice : "); int
	 * subInput5 = scanner.nextInt(); return subInput5; }
	 */

	private static int submenu4() {
		System.out.println();
		System.out.println("1.Add Bill");
		System.out.println("2.Update Bill");
		System.out.println("3.View All Bills");
		System.out.println("4.Generate Bill");
		System.out.println("5.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		int subInput4 = scanner.nextInt();
		return subInput4;
	}

	private static int submenu3() {
		System.out.println();
		System.out.println("1.Add Service Registration");
		System.out.println("2.Update Service Registration");
		System.out.println("3.View All Service Registrations");
		System.out.println("4.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		int subInput3 = scanner.nextInt();
		return subInput3;
	}

	private static int submenu2() {
		System.out.println();
		System.out.println("1.Add Pet");
		System.out.println("2.Update Pet");
		System.out.println("3.View All Pets");

		System.out.println();
		System.out.println("4.Add Pet Category");
		System.out.println("5.Update Pet Category");
		System.out.println("6.View All Pet Categories");
		System.out.println("7.Delete Pet Category By Id");
		System.out.println("8.Go to Main Menu");
		System.out.println();
		System.out.println("Enter Your Choice : ");
		int subInput2 = scanner.nextInt();
		return subInput2;
	}

	private static int submenu1() {
		System.out.println();
		System.out.println("1.Add Customer");
		System.out.println("2.Update Customer");
		System.out.println("3.View All Customer");
		System.out.println("4.Go to Main Menu");

		System.out.println();
		System.out.println("Enter Your Choice : ");
		int subInput = scanner.nextInt();
		return subInput;
	}

	private static void header() {
		System.out.println("*-_-* PET CARE MANAGEMENT SYSTEM *-_-*");
		System.out.println("______________________________________");
		System.out.println();
		System.out.println("** Your pets are our passion. **");
		System.out.println("_________________________________");
		System.out.println();

		System.out.println();
	}

	private static int menu() {
		System.out.println("*** Main Menu ***");
		System.out.println("    *********    ");
		System.out.println("1.Employee");
		System.out.println("2.Customer");
		System.out.println("3.Pet");
		System.out.println("4.Service Registration");
		System.out.println("5.Bill");
		// System.out.println("5.Pet Category");
		System.out.println("6.Log Out");
		System.out.println();
		System.out.println("Enter Your Choice : ");
		int userInput = scanner.nextInt();
		return userInput;
	}

}
