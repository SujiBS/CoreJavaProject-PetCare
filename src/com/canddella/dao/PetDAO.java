package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Pet;

public interface PetDAO {

	int save(Pet pet);

	List<Pet> findAll();

	int update(int categorytId);// updating
	
	Pet findById(int petId);//find by id
}
