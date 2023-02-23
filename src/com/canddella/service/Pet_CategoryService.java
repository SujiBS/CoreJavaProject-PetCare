package com.canddella.service;

import java.util.List;

import com.canddella.entity.Pet_Category;

public interface Pet_CategoryService {
	
	List<Pet_Category> findAll(); //retrieving
	
	void save(Pet_Category department); //inserting
	
	void updateById(int categorytId);//updating
	
	Pet_Category findById(int petCate_Id);//find by id
	
	void deletePetCategoryById(Pet_Category pet_Category);//delete
}
