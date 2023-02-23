package com.canddella.util;

import java.util.Scanner;

public class LoginTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		checkLogin();
	}

	public static boolean checkLogin() {
		System.out.println("LOGIN DETAILS");
		System.out.println("*************");
		System.out.println();
		
		System.out.println("User Name : ");
		String userName = scanner.nextLine();
		
		System.out.println("Password : ");
		String password = scanner.nextLine();
		
		if(userName.equals( "pcms")  && password.equals( "pcms123")) {
			System.out.println("You are Logged In Successfully....");
			System.out.println();
			return true;
		}
		else {
			System.out.println("Incorrect UserName or Password...");
			System.out.println();
			return false;
		}
		
		
	}

}
