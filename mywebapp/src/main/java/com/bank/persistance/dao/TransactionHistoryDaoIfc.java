package com.bank.persistance.dao;

import java.util.List;

import com.bank.persistance.model.TransactionHistory;

public interface TransactionHistoryDaoIfc {
	
	void save(TransactionHistory transaction);
	
	List<TransactionHistory> getTransactionList(int acctNo);

}
