package com.canddella.service;

import java.util.List;

import com.canddella.dao.BillDAOImpl;

import com.canddella.entity.Bill;


public class BillServiceImpl implements BillService {

	@Override
	public int save(Bill bill) {
		

		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.save(bill);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		
		return 0;
	}

	@Override
	public List<Bill> findAll() {
		BillDAOImpl billDAOImpl =new BillDAOImpl();
		List<Bill> billList=billDAOImpl.findAll();

		return billList;
	}

	@Override
	public void updateById(int billId) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		int row = billDAOImpl.update(billId);
		if (row == 1)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		
	}

	public Bill generateBillById(int billId) {
		BillDAOImpl billDAOImpl = new BillDAOImpl();
		Bill row = billDAOImpl.generateBillById(billId);
		return row;
		
	}

	

}
