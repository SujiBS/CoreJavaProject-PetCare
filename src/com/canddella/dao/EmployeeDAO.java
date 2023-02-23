package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll(); // retrieving

	int save(Employee employee); // inserting

	int update(int empId);// updating
	
	Employee findById(int empId);//find by id

}
