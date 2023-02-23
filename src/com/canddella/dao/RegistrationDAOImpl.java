package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.Pet;
import com.canddella.entity.Registration;

public class RegistrationDAOImpl implements RegistrationDAO {

	@Override
	public int save(Registration registration) {

		String insertSQL = "insert into registration(customer_id,pet_id,date,time)"
				+ " values(?,?,?,?)";
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			
		

			preparedStatement.setInt(1, registration.getCustomer().getCustomerId());
			preparedStatement.setInt(2, registration.getPet().getPetId());
			//preparedStatement.setDate(3, registration.getDate());
			
			//preparedStatement.setDate(3, java.sql.Date.valueOf(registration.getDate()));
			preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			//preparedStatement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			int row = preparedStatement.executeUpdate();
			return row;

		} catch (SQLException e) {
			// e.getMessage();
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				
				e.getMessage();
				//e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Registration> findAll() {


		List<Registration> registrationList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from registration";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int regId = resultSet.getInt(1);
				
				int customerId = resultSet.getInt(2);
				int petId = resultSet.getInt(3);
				Date date = resultSet.getDate(4);
				Time time = resultSet.getTime(5);
				
				
				
				Customer customer= new Customer();
				customer.setCustomerId(customerId);
				Pet pet=new Pet();
				pet.setPetId(petId);
				
				Registration registration=new Registration(regId, customer, pet, date, time);
				
				registrationList.add(registration);

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

		return registrationList;
	
	}

	@Override
	public int update(int registrId) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the Customer Id:");
		int customerId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Pet Id:");
		int petId = scanner.nextInt();
		scanner.nextLine();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "update registration set customer_id= ? ,pet_id= ?,date= ?,time= ? where reg_id="+ registrId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, petId);
			preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			
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
				e.getMessage();
				//e.printStackTrace();
			}
		}
		return 0;
	}

	public Registration findById(int regId) {
		Registration registration=null;
	
	Connection connection = null;
	PreparedStatement prepStmt = null;

	String selectSQL = "Select * from registration where reg_id="+ regId;
	try {
		DataSource ds = DBConnectionPool.getDataSource();
		connection = ds.getConnection();
		prepStmt = connection.prepareStatement(selectSQL);
		ResultSet resultSet = prepStmt.executeQuery();
		while (resultSet.next()) {
			 int reg_ID = resultSet.getInt(1);
			 int cust_ID = resultSet.getInt(2);
			 int pet_ID = resultSet.getInt(3);
			Date date=resultSet.getDate(4);
			Time time=resultSet.getTime(5);
			
			Customer customer = new Customer();//***foreign key
			customer.setCustomerId(cust_ID);//**
			
			Pet pet = new Pet();
			pet.setPetId(pet_ID);
			
			
			 registration = new Registration(reg_ID, customer, pet, date, time);
			

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

	return registration;
}

}
