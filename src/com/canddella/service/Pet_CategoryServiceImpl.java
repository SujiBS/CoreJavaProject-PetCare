package com.canddella.service;

import java.util.List;

import com.canddella.dao.CustomerDAOImpl;
import com.canddella.dao.Pet_CategoryDAOImpl;
import com.canddella.entity.Pet_Category;

public class Pet_CategoryServiceImpl implements Pet_CategoryService {

	@Override
	public List<Pet_Category> findAll() {

		
		Pet_CategoryDAOImpl petCategoryDAOImpl =new Pet_CategoryDAOImpl();
		List<Pet_Category> petCategorytList=petCategoryDAOImpl.findAll();

		return petCategorytList;
	
	}

	@Override
	public void save(Pet_Category petCategory) {
		Pet_CategoryDAOImpl petCategorytDAOImpl = new Pet_CategoryDAOImpl();
		int row = petCategorytDAOImpl.save(petCategory);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		
	}

	@Override
	public void updateById(int categorytId) {
		Pet_CategoryDAOImpl pet_CategoryDAOImpl = new Pet_CategoryDAOImpl();
		int row = pet_CategoryDAOImpl.update(categorytId);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		
	}

	public Pet_Category findById(int petCate_Id) {
		Pet_CategoryDAOImpl pet_CategoryDAOImpl = new Pet_CategoryDAOImpl();
		Pet_Category row = pet_CategoryDAOImpl.findById(petCate_Id);
		return row;
	}

	public void deletePetCategoryById(Pet_Category pet_Category) {
		Pet_CategoryDAOImpl pet_CategoryDAOImpl = new Pet_CategoryDAOImpl();
		int row = pet_CategoryDAOImpl.deletePetCategoryById(pet_Category);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		
	}

	

}
