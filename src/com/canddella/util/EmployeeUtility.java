package com.canddella.util;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Employee;
import com.canddella.service.EmployeeServiceImpl;

public class EmployeeUtility {

	public static void main(String[] args) {
		findById();

		updateEmployee();
		getAllEmployee();
		insertIntoEmployee();

	}

	private static void findById() {
		getAllEmployee();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Employee Id to find: ");
		int empId = scanner.nextInt();

		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Employee employee = employeeServiceImpl.findById(empId);

		System.out.println("********************************************");
		System.out.println("****************- Customer Details By ID-*******************");
		System.out.println("Employee ID : " + employee.getEmployee_id());
		System.out.println("Employee Name : " + employee.getEmployee_name());
		System.out.println("Experirnce : " + employee.getExperience());
		System.out.println("Work Category : " + employee.getWork_category());

		System.out.println("********************************************");

	}

	public static void updateEmployee() {
		getAllEmployee();

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Update Employee***********************");

		System.out.println("Enter the Employee Id to Update: ");
		int empId = scanner.nextInt();

		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.updateById(empId);

		getAllEmployee();
	}

	public static void insertIntoEmployee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Employee***********************");
		/*
		 * System.out.println("Enter Employee ID:"); int empId = scanner.nextInt();
		 * scanner.nextLine();
		 */
		System.out.println("Enter Employee Name:");
		String empName = scanner.nextLine();

		System.out.println("Enter Year of Experience:");
		int experience = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter Work Category:");
		String work = scanner.nextLine();

		Employee employee = new Employee(empName, experience, work);
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.save(employee);

		getAllEmployee();
	}

	public static void getAllEmployee() {

		EmployeeServiceImpl customerServiceImpl = new EmployeeServiceImpl();
		List<Employee> employeeList = customerServiceImpl.findAll();
		System.out.println();
		System.out.println("\t" + "*************");
		System.out.println("\t" + "EMPLOYEE DETAILS");
		System.out.println("\t" + "*************");

		System.out.println("Employee Id" + "\t" + "Employee Name" + "\t" + "Experience" + "\t" + "Work Category");
		System.out.println("_____________________________________________________________________");
		for (Employee employee : employeeList) {
			System.out.println(employee.getEmployee_id() + "\t\t" + employee.getEmployee_name() + "\t\t"
					+ employee.getExperience() + "\t\t" + employee.getWork_category());
			System.out.println("_________________________________________________________________");
			System.out.println();
		}
	}

	public static void menu() {
		int subInput6;
		do {
			System.out.println();
			System.out.println("1.Add Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.View All Employees");
			System.out.println("4.Go to Main Menu");

			System.out.println();
			System.out.println("Enter Your Choice : ");
			Scanner scanner = new Scanner(System.in);
			subInput6 = scanner.nextInt();
			// boolean condition=true;

			switch (subInput6) {

			case 1:
				insertIntoEmployee();
				// System.out.println();
				break;
			case 2:
				updateEmployee();
				System.out.println();
				break;
			case 3:
				getAllEmployee();
				System.out.println();
				break;
			case 4:
				System.out.println("*************************************************");

				System.out.println();
				break;
			default:
				System.out.println("Invalid Choice");

			}

		} while (subInput6 <= 3);
	}

}
