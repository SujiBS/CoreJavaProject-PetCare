package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Registration;

public interface RegistrationDAO {

	int save(Registration registration);

	List<Registration> findAll();

	int update(int registrId);// updating
	
	Registration findById(int regId);//find by id

}
