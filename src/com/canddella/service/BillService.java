package com.canddella.service;

import java.util.List;

import com.canddella.entity.Bill;


public interface BillService {

	int save(Bill bill);
	List<Bill> findAll() ;
	void updateById(int billId);//updating
	//List<Bill> printBill(int billId);
	
	Bill generateBillById(int billId);
}
