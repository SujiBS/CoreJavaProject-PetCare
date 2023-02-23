package com.canddella.util;

import java.util.Scanner;

public class menu {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Pet_CategoryUtility pet_CategoryUtility = new Pet_CategoryUtility();
		CustomerUtility customerUtility = new CustomerUtility();
		EmployeeUtility employeeUtility = new EmployeeUtility();
		PetUtility petUtility = new PetUtility();
		RegistrationUtility registrationUtility = new RegistrationUtility();
		BillUtility billUtility = new BillUtility();

		boolean temp = true;
		header();
		while (temp) {
			printMenu();
			int userInput = scanner.nextInt();
			switch (userInput) {
			case 1:

				System.out.println("Service Available Categories");
				System.out.println("****************************");
				System.out.println();

				pet_CategoryUtility.getAllPet_category();

				break;
			case 2:

				System.out.println("Add Pet Categories");
				System.out.println("****************************");
				System.out.println();

				pet_CategoryUtility.insertIntoPet_category();

				break;
			case 3:

				System.out.println("Update Pet Categories");
				System.out.println("****************************");
				System.out.println();
				
				pet_CategoryUtility.updatePet_Category();

				break;
			case 4:

				System.out.println("Customer Registration");
				System.out.println("****************************");
				System.out.println();

				customerUtility.insertIntoCustomer();

				break;
			case 5:

				System.out.println("View All Customers");
				System.out.println("****************************");
				System.out.println();

				customerUtility.getAllCustomer();

				break;
			case 6:

				System.out.println("Update Customer");
				System.out.println("****************************");
				System.out.println();

				customerUtility.updateCustomer();
				
				break;
			case 7:

				System.out.println("Pet Registration");
				System.out.println("****************************");
				System.out.println();

				petUtility.insertIntoPet();

				break;
			case 8:

				System.out.println("View All Pets");
				System.out.println("****************************");
				System.out.println();

				petUtility.getAllPet();

				break;
			case 9:

				System.out.println("Update Pet");
				System.out.println("****************************");
				System.out.println();

				petUtility.updatePet();
				
				break;
			case 10:

				System.out.println("Employee Registration");
				System.out.println("****************************");
				System.out.println();

				employeeUtility.insertIntoEmployee();

				break;
			case 11:

				System.out.println("View All Employees");
				System.out.println("****************************");
				System.out.println();

				employeeUtility.getAllEmployee();

				break;
			case 12:

				System.out.println("Update Employee");
				System.out.println("****************************");
				System.out.println();

				employeeUtility.updateEmployee();
				
				break;
			case 13:

				System.out.println("Service Registration");
				System.out.println("****************************");
				System.out.println();

				registrationUtility.insertIntoRegistration();

				break;
			case 14:

				System.out.println("View All Service Registrations");
				System.out.println("****************************");
				System.out.println();

				registrationUtility.getAllRegistration();

				break;
			case 15:

				System.out.println("Update Service Registration");
				System.out.println("****************************");
				System.out.println();

				registrationUtility.updateRegistration();
				
				break;
			case 16:

				System.out.println("Bill");
				System.out.println("****************************");
				System.out.println();

				billUtility.insertIntoBill();

				break;
			case 17:

				System.out.println("View All Bills");
				System.out.println("****************************");
				System.out.println();

				billUtility.getAllBill();

				break;
			case 18:

				System.out.println("Update Bill");
				System.out.println("****************************");
				System.out.println();

				billUtility.updateBill();
				break;

			case 19:

				System.out.println("Log Out.. ");
				temp = false;
				break;

			default:

				System.out.println("Enter a valid menu");

				break;

			}
			System.out.println("##########################");
		}
	}

	private static void header() {
		System.out.println("*-_-* PET CARE MANAGEMENT SYSTEM *-_-*");
		System.out.println("______________________________________");
		System.out.println();
		System.out.println("** Your pets are our passion. **");
		System.out.println("_________________________________");
		System.out.println();
		LoginTest login = new LoginTest();
		login.checkLogin();
	}

	private static void printMenu() {

		System.out.println("*** Main Menu ***");
		System.out.println("    *********    ");
		System.out.println("1.Check Service Available Categories");
		System.out.println("2. Add Pet Categories");
		System.out.println("3. Update Pet Categories");
		
		System.out.println();
		System.out.println();
		
		System.out.println("4. Customer Registration");
		System.out.println("5. View All Customers");
		System.out.println("6. Update Customer");
		
		System.out.println();
		System.out.println();
		
		System.out.println("7. Pet Registration");
		System.out.println("8. View All Pets");
		System.out.println("9. Update Pet");
		
		System.out.println();
		System.out.println();
		
		System.out.println("10. Employee Registration");
		System.out.println("11. View All Employees");
		System.out.println("12. Update Employee");
		
		System.out.println();
		System.out.println();
		
		System.out.println("13. Service Registration");
		System.out.println("14. View All Service Registrations");
		System.out.println("15. Update Service Registration");
		
		System.out.println();
		System.out.println();
		
		System.out.println("16. Bill");
		System.out.println("17. View All Bills");
		System.out.println("18. Update Bill");

		System.out.println();
		System.out.println();
		
		System.out.println("19.Log Out");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Enter your choice :");

	}

}
