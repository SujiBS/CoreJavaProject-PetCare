package com.canddella.service;

import java.util.List;

import com.canddella.entity.Registration;

public interface RegistrationService {

	int save(Registration registration);

	List<Registration> findAll();

	void updateById(int registrId);// updating
	
	Registration findById(int regId);//find by id
}
