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
import com.canddella.entity.Pet;
import com.canddella.entity.Pet_Category;

public class PetDAOImpl implements PetDAO {

	@Override
	public int save(Pet pet) {

		String insertSQL = "insert into pet(pet_name,pet_age,pet_colour,pet_gender,pet_breed,vaccination,weight,height,disabilities,customer_id,category_id)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			
		

			preparedStatement.setString(1, pet.getPetName());
			preparedStatement.setInt(2, pet.getAge());
			preparedStatement.setString(3, pet.getColour());
			preparedStatement.setString(4, pet.getGender());
			preparedStatement.setString(5, pet.getBreed());
			preparedStatement.setString(6, pet.getVaccination());
			preparedStatement.setDouble(7, pet.getWeight());
			preparedStatement.setDouble(8, pet.getHeight());
			preparedStatement.setString(9, pet.getDisabilities());

			preparedStatement.setInt(10, pet.getCustomer().getCustomerId());
			
			preparedStatement.setInt(11, pet.getPetCategory().getCategoryId());

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
				// TODO Auto-generated catch block
				 e.getMessage();
				//e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Pet> findAll() {

		List<Pet> petList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from pet";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int petId = resultSet.getInt(1);
				
				int customerId = resultSet.getInt(2);
				int categoryId = resultSet.getInt(3);
				String petName = resultSet.getString(4);
				int petAge = resultSet.getInt(5);
				String petColour = resultSet.getString(6);
				//int age = resultSet.getInt(5);
				String petGender = resultSet.getString(7);
				String petBreed = resultSet.getString(8);
				String vaccination = resultSet.getString(9);
				
				double weight=resultSet.getDouble(10);
				double height=resultSet.getDouble(11);
				String disabilities = resultSet.getString(12);
				
				Customer customer= new Customer();
				customer.setCustomerId(customerId);
				Pet_Category petCategory=new Pet_Category();
				petCategory.setCategoryId(categoryId);
				
				Pet pet=new Pet(petId, customer, petCategory, petName, petAge, petColour, petGender, petBreed, vaccination, weight, height, disabilities);
				
				petList.add(pet);

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

		return petList;
	}

	@Override
	public int update(int petId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Customer Id:");
		int customerId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Pet Category Id:");
		int categoryId = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Pet Name:");
		String petName = scanner.nextLine();

		System.out.println("Enter the Age of Pet:");
		int petAge = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the Colour of Pet:");
		String petColour = scanner.nextLine();

		System.out.println("Enter the Gender of Pet:");
		String petgender = scanner.nextLine();

		System.out.println("Enter the Breed of Pet:");
		String petBreed = scanner.nextLine();

		System.out.println("Are You Completed All Vaccinations of the Pet ? :(Yes / No)");
		String vaccination = scanner.nextLine();

		System.out.println("Enter the Weight of Pet in Kg:");
		Double petWeight = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter the Height of Pet in cm:");
		Double petHeight = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Your Pet have any Disabilities ? :(Yes / No)");
		String disabilities = scanner.nextLine();


		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "update pet set customer_id= ? ,category_id= ? ,pet_name= ? ,pet_age= ? ,"
				+ "pet_colour= ?,pet_gender= ?,pet_breed= ?,vaccination= ?,weight= ?,height= ?,disabilities= ? where pet_id="+ petId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, categoryId);
			preparedStatement.setString(3, petName);
			preparedStatement.setInt(4, petAge);
			preparedStatement.setString(5, petColour);
			preparedStatement.setString(6, petgender);
			preparedStatement.setString(7, petBreed);
			preparedStatement.setString(8, vaccination);
			preparedStatement.setDouble(9, petWeight);
			preparedStatement.setDouble(10, petHeight);
			preparedStatement.setString(11, disabilities);
			
			int row = preparedStatement.executeUpdate();
			return row;
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			// e.printStackTrace();
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

	public Pet findById(int petId) {
		Pet pet=null;
		
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from pet where pet_id="+ petId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				 int pet_id = resultSet.getInt(1);
				 int cust_id = resultSet.getInt(2);
				 int cate_id = resultSet.getInt(3);
				 String name = resultSet.getString(4);
				 int age =resultSet.getInt(5); 
				 String colour = resultSet.getString(6); 
				 String gender = resultSet.getString(7); 
				 String breed = resultSet.getString(8);
				 String vaccination = resultSet.getString(9); 
				 double weight = resultSet.getDouble(10); 
				 double height = resultSet.getDouble(11); 
				 String disabilities = resultSet.getString(12); 
				 
				 Customer customer = new Customer();
					customer.setCustomerId(cust_id);
					
					 Pet_Category pet_Category = new Pet_Category();
					 pet_Category.setCategoryId(cate_id);
				 
				 pet = new Pet(pet_id, customer, pet_Category, name, age, colour, gender, breed, vaccination, weight, height, disabilities);
				

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

		return pet;
	
	}

}
