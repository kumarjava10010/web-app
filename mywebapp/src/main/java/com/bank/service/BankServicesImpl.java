/**
 * 
 */
package com.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.persistance.dao.AcctInfoDaoIfc;
import com.bank.persistance.dao.TransactionHistoryDaoIfc;
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

	@Autowired
	TransactionHistoryDaoIfc transactionDao;

	/*
	 * @Autowired CustomerDaoIfc customerDao;
	 * 
	 * @Autowired TransactionHistoryDaoIfc transactionDao;
	 */

	public AcctInfo getAcctSummary(int acctNumber) {
		System.out.println("I am in BankServicesImpl class : " + acctNumber);

		return acctInfoDao.findByAcctNumber(acctNumber);
	}

	public AcctInfo withdraw(AcctInfo acctInfo) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date());

		System.out.println("Transaction Amount : " + acctInfo.getTransactionAmount());
		System.out.println("Transaction Type : " + acctInfo.getTransactionType());

		Double transactionAmount = Double.valueOf(acctInfo.getTransactionAmount());

		AcctInfo savedAcctInfo = acctInfoDao.findByAcctNumber(acctInfo.getAcctNumber());

		// Converting String to Double.

		Double currentBalance = Double.valueOf(savedAcctInfo.getBalance());

		Double newBalance = 0.0;

		newBalance = currentBalance - transactionAmount;

		savedAcctInfo.setBalance(newBalance.toString());

		acctInfoDao.update(savedAcctInfo);

		TransactionHistory transaction = new TransactionHistory();

		transaction.setAcctNo(savedAcctInfo.getAcctNumber());
		transaction.setBranchName("CASHIER");
		transaction.setDepositType("CASH");
		transaction.setNewBalance(newBalance.toString());
		transaction.setPrevBalance(currentBalance.toString());
		transaction.setTransactionDate(date);
		transaction.setTransactionType(acctInfo.getTransactionType());
		transaction.setTransactionAmount(transactionAmount.toString());
		transaction.setLastupdateddate(date);

		transactionDao.save(transaction);

		return savedAcctInfo;
	}

	public List<TransactionHistory> getTransactionList(int acctNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public AcctInfo deposit(AcctInfo acctInfo) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date());

		System.out.println("Transaction Amount : " + acctInfo.getTransactionAmount());
		System.out.println("Transaction Type : " + acctInfo.getTransactionType());

		Double transactionAmount = Double.valueOf(acctInfo.getTransactionAmount());

		AcctInfo savedAcctInfo = acctInfoDao.findByAcctNumber(acctInfo.getAcctNumber());

		// Converting String to Double.

		Double currentBalance = Double.valueOf(savedAcctInfo.getBalance());

		Double newBalance = 0.0;

		newBalance = currentBalance + transactionAmount;
		savedAcctInfo.setBalance(newBalance.toString());

		acctInfoDao.update(savedAcctInfo);

		TransactionHistory transaction = new TransactionHistory();

		transaction.setAcctNo(savedAcctInfo.getAcctNumber());
		transaction.setBranchName("CASHIER");
		transaction.setDepositType("CASH");
		transaction.setNewBalance(newBalance.toString());
		transaction.setPrevBalance(currentBalance.toString());
		transaction.setTransactionDate(date);
		transaction.setTransactionType(acctInfo.getTransactionType());
		transaction.setTransactionAmount(transactionAmount.toString());
		transaction.setLastupdateddate(date);

		transactionDao.save(transaction);

		return savedAcctInfo;

	}

}
