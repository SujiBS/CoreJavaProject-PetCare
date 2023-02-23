package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> findAll() {

		List<Employee> employeeList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from employee";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int empId = resultSet.getInt(1);
				String empName = resultSet.getString(2);
				int emp_experience = resultSet.getInt(3);
				String empl_work = resultSet.getString(4);
				
				Employee employee = new Employee(empId, empName, emp_experience, empl_work);
				employeeList.add(employee);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				//e.printStackTrace();
				e.getMessage();
			}
		}

		return employeeList;
	}

	@Override
	public int save(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into employee(employee_name,experience,work_category) values(?,?,?)";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			//preparedStatement.setInt(1, employee.getEmployee_id());
			preparedStatement.setString(1, employee.getEmployee_name());
			preparedStatement.setInt(2, employee.getExperience());
			preparedStatement.setString(3, employee.getWork_category());
			
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				
				//e.printStackTrace();
				e.getMessage();
			}
		}

		return 0;
	}

	@Override
	public int update(int empId) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Employee Name:");
		String empName = scanner.nextLine();

		System.out.println("Enter Year of Experience:");
		int experience = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter Work Category:");
		String work = scanner.nextLine();


		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "update employee set employee_name= ? ,experience= ? ,work_category= ? where employee_id="+ empId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, experience);
			preparedStatement.setString(3, work);
			
			int row = preparedStatement.executeUpdate();
			return row;
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			 e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				
				//e.printStackTrace();
				e.getMessage();
			}
		}
		return 0;
	}

	public Employee findById(int empId) {
		Employee employee=null;
		
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from employee where employee_id="+ empId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				 int emp_Id = resultSet.getInt(1);
				 String name = resultSet.getString(2);
				 int experience = resultSet.getInt(3); 
				 String category = resultSet.getString(4); 
				 
				 employee = new Employee(emp_Id, name, experience, category);
				

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				//e.printStackTrace();
				e.getMessage();
			}
		}

		return employee;
	
	}

}
