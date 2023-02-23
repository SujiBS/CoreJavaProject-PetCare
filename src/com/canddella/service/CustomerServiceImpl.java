package com.canddella.service;

import java.util.List;

import com.canddella.dao.CustomerDAOImpl;

import com.canddella.entity.Customer;


public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> findAll() {
		CustomerDAOImpl customerDAOImpl =new CustomerDAOImpl();
		List<Customer> customerList=customerDAOImpl.findAll();

		return customerList;
	}

	@Override
	public void save(Customer customer) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.save(customer);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		

	}

	public void updateById(int custId) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		int row = customerDAOImpl.update(custId);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		

	}

	public Customer findById(int custId) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		Customer row = customerDAOImpl.findById(custId);
		return row;
	}

}
