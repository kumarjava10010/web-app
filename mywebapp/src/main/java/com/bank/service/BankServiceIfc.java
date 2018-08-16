package com.bank.service;

import java.util.List;

import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.TransactionHistory;

public interface BankServiceIfc {
	
	public AcctInfo getAcctSummary(int acctNumber); 
	
	public AcctInfo deposit(AcctInfo account);
	
	public AcctInfo withdraw(AcctInfo account);
	
	public List<TransactionHistory> getTransactionList(int acctNumber);
	

}
