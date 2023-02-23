package com.canddella.service;

import java.util.List;

import com.canddella.dao.PetDAOImpl;
import com.canddella.dao.RegistrationDAOImpl;
import com.canddella.entity.Pet;
import com.canddella.entity.Registration;

public class RegistrationServiceImpl implements RegistrationService {

	@Override
	public int save(Registration registration) {
		

		RegistrationDAOImpl registrationDAOImpl = new RegistrationDAOImpl();
		int row = registrationDAOImpl.save(registration);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		
		return 0;
	}

	@Override
	public List<Registration> findAll() {
		RegistrationDAOImpl registrationDAOImpl =new RegistrationDAOImpl();
		List<Registration> registrationList=registrationDAOImpl.findAll();

		return registrationList;
	}

	@Override
	public void updateById(int registrId) {
		RegistrationDAOImpl registrationDAOImpl = new RegistrationDAOImpl();
		int row = registrationDAOImpl.update(registrId);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		
		
	}

	public Registration findById(int regId) {
		RegistrationDAOImpl registrationDAOImpl = new RegistrationDAOImpl();
		Registration row = registrationDAOImpl.findById(regId);
		return row;
	}

}
