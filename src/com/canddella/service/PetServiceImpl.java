package com.canddella.service;


import java.util.List;

import com.canddella.dao.CustomerDAOImpl;
import com.canddella.dao.PetDAOImpl;
import com.canddella.entity.Customer;
import com.canddella.entity.Pet;

public class PetServiceImpl implements PetService {

	@Override
	public int save(Pet pet) {
		

		PetDAOImpl petDAOImpl = new PetDAOImpl();
		int row = petDAOImpl.save(pet);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		
		return 0;
	}

	@Override
	public List<Pet> findAll() {
		PetDAOImpl petDAOImpl =new PetDAOImpl();
		List<Pet> petList=petDAOImpl.findAll();

		return petList;
	}

	@Override
	public void updateById(int petId) {
	PetDAOImpl petDAOImpl = new PetDAOImpl();
	int row = petDAOImpl.update(petId);
	if (row == 1)
		System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
	else
		System.out.println("UPDATION FAILED!!!!!!!!!!!!");}

	public Pet findById(int petId) {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		Pet row = petDAOImpl.findById(petId);
		return row;
	}

}
