package com.canddella.util;

import java.sql.SQLException;
import java.util.Scanner;

import com.canddella.dao.LoginDAO;
import com.canddella.dao.LoginDAOImpl;

public class LoginUtility {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		//MainMenuBar.header();
		checkLogin();
		
	}
	public static void checkLogin() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*** Login ***");
		System.out.println("-------------------------------");
		System.out.println();

		System.out.println("User Name :");
		String userName = scanner.nextLine();
		System.out.println("Password :");
		String password = scanner.nextLine();

		LoginDAOImpl loginDao = new LoginDAOImpl();
		boolean isLoginValid;
		try {
			isLoginValid = loginDao.findByUsernameAndPassword(userName, password);
			if (isLoginValid) {
				//DisplayAllMenu.displayMenu();
				System.out.println("Login Successfully...");
				ProjectMenu.projectMenu();

				//MainMenuBar.caseChecking();
			} else {
				System.out.println("Incorrect Login credentials. Try again");
				System.out.println();
				checkLogin();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
