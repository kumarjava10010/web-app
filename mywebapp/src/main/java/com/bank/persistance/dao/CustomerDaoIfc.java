package com.bank.persistance.dao;

import com.bank.persistance.model.Customer;

public interface CustomerDaoIfc {

	void save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer findByAcctNumber(int acctNumer);
}
