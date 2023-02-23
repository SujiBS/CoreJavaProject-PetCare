package com.canddella.service;

import java.util.List;

import com.canddella.entity.Customer;



public interface CustomerService {


	List<Customer> findAll(); //retrieving
	
	void save(Customer department); //inserting
	
	void updateById(int custId);//updating
	
	Customer findById(int custId);//find By id
}
