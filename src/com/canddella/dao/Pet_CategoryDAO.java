package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Pet_Category;

public interface Pet_CategoryDAO {


	List<Pet_Category> findAll(); //retrieving
	
	int save(Pet_Category petCategory); //inserting
	
	int update(int categorytId);//updating
	
	Pet_Category findById(int petCate_Id);//find by id
	
	int deletePetCategoryById(Pet_Category pet_Category);//delete
}
