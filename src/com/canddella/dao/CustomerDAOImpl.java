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
import com.canddella.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> findAll() {

		List<Customer> customerList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from customer";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int customerId = resultSet.getInt(1);
				String customerName = resultSet.getString(2);
				String emailId = resultSet.getString(3);
				String phoneNumber = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String address = resultSet.getString(6);
				Customer customer = new Customer(customerId, customerName, emailId, phoneNumber, age, address);
				customerList.add(customer);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return customerList;
	}

	@Override
	public int save(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into customer(customer_name,email_id,phone_num,age,address) values(?,?,?,?,?)";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			// preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getEmailId());
			preparedStatement.setString(3, customer.getPhoneNumber());
			preparedStatement.setInt(4, customer.getAge());
			preparedStatement.setString(5, customer.getAddress());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				e.getMessage();
			}
		}

		return 0;
	}

	public int update(int custId) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer Name:");
		String newCustName = scanner.nextLine();
		System.out.println("Enter Customer Email Id:");
		String newEmail = scanner.nextLine();
		System.out.println("Enter CustomerPhone Number:");
		String newPhn_num = scanner.nextLine();
		System.out.println("Enter Customer Age:");
		int newAge = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Customer Address:");
		String newAddress = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update customer set customer_name= ? ,email_id= ? ,phone_num= ? ,age= ? ,address= ? where customer_id="+ custId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, newCustName);
			preparedStatement.setString(2, newEmail);
			preparedStatement.setString(3, newPhn_num);
			preparedStatement.setInt(4, newAge);
			preparedStatement.setString(5, newAddress);
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

	public Customer findById(int custId) {
		
		Customer customer=null;
		
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from customer where customer_id="+ custId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				 int cust_id = resultSet.getInt(1);
				 String name = resultSet.getString(2);
				 String email = resultSet.getString(3); 
				 String phno = resultSet.getString(4); 
				 int age =resultSet.getInt(5); 
				 String address = resultSet.getString(6);
				customer = new Customer(custId, name, email, phno, age, address);
				

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

		return customer;
	}

}
