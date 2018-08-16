package com.bank.persistance.dao;

import com.bank.persistance.model.AcctInfo;

public interface AcctInfoDaoIfc {
	
	void save(AcctInfo account);
	void update(AcctInfo account);
	void delete(AcctInfo account);
	AcctInfo findByAcctNumber(int acctNumer);

}
