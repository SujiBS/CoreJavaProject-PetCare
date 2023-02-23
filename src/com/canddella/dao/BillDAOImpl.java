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
import com.canddella.entity.Bill;
import com.canddella.entity.Customer;
import com.canddella.entity.Registration;

public class BillDAOImpl implements BillDAO {

	@Override
	public int save(Bill bill) {

		String insertSQL = "insert into Bill(reg_id,amount,payment_mode)" + " values(?,?,?)";
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1, bill.getRegistration().getRegId());
			preparedStatement.setDouble(2, bill.getAmount());
			preparedStatement.setString(3, bill.getPaymentMode());

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
				//e.printStackTrace();
				 e.getMessage();
				
			}
		}
		return 0;
	}

	@Override
	public List<Bill> findAll() {

		List<Bill> billList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bill";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int billId = resultSet.getInt(1);
				int regId = resultSet.getInt(2);
				double amount = resultSet.getDouble(3);
				String mode = resultSet.getString(4);

				Registration registration = new Registration();
				registration.setRegId(regId);

				Bill bill = new Bill(billId, registration, amount, mode);
				billList.add(bill);
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

		return billList;
	}

	@Override
	public int update(int billId) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Registration Id:");
		int regId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Amount :");
		Double amount = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter the Payment Mode (Offline / Online) :");
		String mode = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "update bill set reg_id= ? ,amount= ? ,payment_mode= ?  where bill_id=" + billId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, regId);
			preparedStatement.setDouble(2, amount);
			preparedStatement.setString(3, mode);

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Bill generateBillById(int billId) {
		Bill bill = null;
		// List<Bill> billList = new ArrayList();
		Customer customer;
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bill where bill_id=" + billId;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int bill_id = resultSet.getInt(1);
				int regId = resultSet.getInt(2);
				double amount = resultSet.getDouble(3);
				String mode = resultSet.getString(4);

				Registration registration = new Registration();
				registration.setRegId(regId);

				String selectSQL2 = "Select customer_id from registration where reg_id=" + regId;
				try {
					DataSource ds2 = DBConnectionPool.getDataSource();
					connection = ds2.getConnection();
					prepStmt = connection.prepareStatement(selectSQL2);
					ResultSet resultSet2 = prepStmt.executeQuery();
					while (resultSet2.next()) {
						int cust_id = resultSet2.getInt(1);
						//System.out.println("cust_id =" + cust_id);

						String selectSQL3 = "Select * from customer where customer_id=" + cust_id;
						try {
							DataSource ds3 = DBConnectionPool.getDataSource();
							connection = ds3.getConnection();
							prepStmt = connection.prepareStatement(selectSQL3);
							ResultSet resultSet3 = prepStmt.executeQuery();
							while (resultSet3.next()) {
								int custmr_id = resultSet3.getInt(1);
								String customer_name = resultSet3.getString(2);
								String email = resultSet3.getString(3);
								String phno = resultSet3.getString(4);
								int age = resultSet3.getInt(5);
								String address = resultSet3.getString(6);

								System.out.println("customer_id =" + custmr_id);
								System.out.println("customer_name =" + customer_name);
								System.out.println();
								customer = new Customer(customer_name, email, phno, age, address);
								registration.setCustomer(customer);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// customer.setCustomerName(customer.getCustomerName());
				// System.out.println("**checking**"+customer.getCustomerName());
				// System.out.println("**checking**"+registration.getCustomer().getCustomerName());

				bill = new Bill(bill_id, registration, amount, mode);

				// bill.setRegistration(registration);

				// billList.add(bill);
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

		return bill ;
	}

}
