package com.canddella.service;

import java.util.List;

import com.canddella.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll(); // retrieving

	void save(Employee employee); // inserting

	void updateById(int empId);// updating
	
	Employee findById(int empId);//find by id
}
