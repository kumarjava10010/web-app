package com.bank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.persistance.dao.AcctInfoDaoIfc;
import com.bank.persistance.dao.TransactionHistoryDaoIfc;
import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.TransactionHistory;

@Transactional
@Controller
public class AccountController {

	@Autowired
	AcctInfoDaoIfc acctInfoDao;
	
	@Autowired
	TransactionHistoryDaoIfc transactionDao;

	@RequestMapping(value = "/depositWithdraw", method = RequestMethod.POST)
	public ModelAndView getAccountSummary(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("acctInfo") AcctInfo acctInfo) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date()); 

		System.out.println("Transaction Amount : " + acctInfo.getTransactionAmount());
		System.out.println("Transaction Type : " + acctInfo.getTransactionType());

		Double transactionAmount = Double.valueOf(acctInfo.getTransactionAmount());

		AcctInfo savedAcctInfo = acctInfoDao.findByAcctNumber(acctInfo.getAcctNumber());

		// Converting String to Double.

		Double currentBalance = Double.valueOf(savedAcctInfo.getBalance());
		
		Double newBalance = 0.0;
		
		if ("deposit".equals(acctInfo.getTransactionType())) {
			newBalance = currentBalance + transactionAmount;
		} else if ("withdraw".equals(acctInfo.getTransactionType())) {
			newBalance = currentBalance - transactionAmount;
		}
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

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("accountSummary");

		// Passing new acctInfo Pojo class to map with view
		mav.addObject("acctInfo", savedAcctInfo);

		return mav;
	}

}
