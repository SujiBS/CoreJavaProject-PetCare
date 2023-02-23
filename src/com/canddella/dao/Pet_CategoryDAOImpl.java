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
import com.canddella.entity.Pet_Category;

public class Pet_CategoryDAOImpl implements Pet_CategoryDAO {

	@Override
	public List<Pet_Category> findAll() {

		List<Pet_Category> petCategoryList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from pet_category";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int petCategoryId = resultSet.getInt(1);
				String petCategoryName = resultSet.getString(2);

				Pet_Category petCategory = new Pet_Category(petCategoryId, petCategoryName);
				petCategoryList.add(petCategory);

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

		return petCategoryList;
	}

	@Override
	public int save(Pet_Category petCategory) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into pet_category(category_name) values(?)";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			// preparedStatement.setInt(1, petCategory.getCategoryId());
			preparedStatement.setString(1, petCategory.getCategoryName());

			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			e.getMessage();
		}

		finally {
			try {
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				
			//	e.printStackTrace();
				e.getMessage();
			}
		}

		return 0;
	}

	@Override
	public int update(int categorytId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Category Name:");
		String newCategoryName = scanner.nextLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "update pet_category set category_name= ?  where category_id=" + categorytId;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, newCategoryName);

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

	public Pet_Category findById(int petCate_Id) {
		Pet_Category pet_Category = null;

		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from pet_category where category_id=" + petCate_Id;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int Cate_Id = resultSet.getInt(1);
				String Cate_name = resultSet.getString(2);

				pet_Category = new Pet_Category(Cate_Id, Cate_name);

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

		return pet_Category;

	}

	public int deletePetCategoryById(Pet_Category pet_Category) {
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String DeleteSQL = "delete from pet_category where category_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(DeleteSQL);
			
			prepStmt.setInt(1, pet_Category.getCategoryId());
			int row = prepStmt.executeUpdate();
			return row;

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

		return 0;
	}

}
