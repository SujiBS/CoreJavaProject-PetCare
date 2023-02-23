package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Bill;

public interface BillDAO {

	int save(Bill bill);
	List<Bill> findAll() ;
	int update(int billId);//updating
	//int save(int billId);
	
	Bill generateBillById(int billId);
}
