package com.canddella.service;

import java.util.List;

import com.canddella.dao.CustomerDAOImpl;
import com.canddella.dao.EmployeeDAOImpl;
import com.canddella.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> findAll() {
		EmployeeDAOImpl employeeDAOImpl =new EmployeeDAOImpl();
		List<Employee> employeeList=employeeDAOImpl.findAll();

		return employeeList;
	}

	@Override
	public void save(Employee employee) {
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		int row = employeeDAOImpl.save(employee);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		

	}

	@Override
	public void updateById(int empId) {
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		int row = employeeDAOImpl.update(empId);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		
		
	}

	public Employee findById(int empId) {
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		Employee row = employeeDAOImpl.findById(empId);
		return row;
	}

}
