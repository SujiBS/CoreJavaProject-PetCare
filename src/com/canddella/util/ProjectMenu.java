package com.canddella.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class ProjectMenu {

	public static void main(String[] args) {
		projectMenu();


	}
	public static void projectMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("*-_-* PET CARE MANAGEMENT SYSTEM *-_-*");
		System.out.println("______________________________________");
		System.out.println();
		System.out.println("** Your pets are our passion. **");
		System.out.println("_________________________________");
		System.out.println();

		System.out.println();
		boolean condition = true;
		do {
			System.out.println("*** Main Menu ***");
			System.out.println("    *********    ");
			System.out.println("1.Employee");
			System.out.println("2.Customer");
			System.out.println("3.Pet");
			System.out.println("4.Service Registration");
			System.out.println("5.Bill");
			// System.out.println("5.Pet Category");
			System.out.println("6.Log Out");
			System.out.println("Enter Your Choice : ");
			int userInput = scanner.nextInt();

			switch (userInput) {
			case 1:
				EmployeeUtility.menu();
				System.out.println("\n");
				break;

			case 2:
				CustomerUtility.menu();
				System.out.println("\n");
				break;

			case 3:
				PetUtility.menu();
				System.out.println("\n");
				break;

			case 4:
				RegistrationUtility.menu();
				System.out.println("\n");
				break;

			case 5:
				BillUtility.menu();
				System.out.println("\n");
				break;

			

			case 6:
				System.out.println("*******************THANK YOU!*****************");
				condition = false;
				break;
			
			default:
				System.out.println("Invalid Option!");

			}
		} while (condition);

	}

}
