/**
 * 
 */
package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.persistance.dao.AcctInfoDaoIfc;
import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.TransactionHistory;

/**
 * @author cragh
 *
 */
@Service("bankService")
@Transactional
public class BankServicesImpl implements BankServiceIfc {

	@Autowired
	AcctInfoDaoIfc acctInfoDao;

	/*
	 * @Autowired CustomerDaoIfc customerDao;
	 * 
	 * @Autowired TransactionHistoryDaoIfc transactionDao;
	 */

	public AcctInfo getAcctSummary(int acctNumber) {
		
		return acctInfoDao.findByAcctNumber(acctNumber);
	}

	

	public AcctInfo withdraw(AcctInfo account) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TransactionHistory> getTransactionList(int acctNumber) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public AcctInfo deposit(AcctInfo account) {
		
		double balance = Double.valueOf(account.getBalance()); 
		
		
		
		acctInfoDao.save(account);
		
		//acctInfoDao.update(account);
		
		
		return account;
	}

}
