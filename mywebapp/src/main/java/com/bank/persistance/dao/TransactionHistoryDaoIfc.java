package com.bank.persistance.dao;

import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.TransactionHistory;

public interface TransactionHistoryDaoIfc {
	
	void save(TransactionHistory transaction);
	void update(TransactionHistory transaction);
	void delete(TransactionHistory transaction);
	AcctInfo findByAcctNumber(int acctNumer);

}
