package com.canddella.service;

import java.util.List;


import com.canddella.entity.Pet;

public interface PetService {
	
	int save(Pet pet);//insert
	List<Pet> findAll() ;//select
	void updateById(int petId);//updating
	Pet findById(int petId);//find by id
	
}
