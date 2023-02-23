package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;



public interface CustomerDAO {

	List<Customer> findAll(); //retrieving
	
	int save(Customer customer); //inserting
	
	int update(int custId);//updating
	
	Customer findById(int custId);//find by id
}
