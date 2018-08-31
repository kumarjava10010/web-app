package com.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.persistance.model.AcctInfo;
import com.bank.service.BankServiceIfc;

@Transactional
@Controller
public class AccountController {

	/*@Autowired
	AcctInfoDaoIfc acctInfoDao;
	
	@Autowired
	TransactionHistoryDaoIfc transactionDao;*/
	
	@Autowired
	BankServiceIfc bankService;

	@RequestMapping(value = "/depositWithdraw", method = RequestMethod.POST)
	public ModelAndView getAccountSummary(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("acctInfo") AcctInfo acctInfo) {
		
		AcctInfo savedAcctInfo = null;
		if ("deposit".equals(acctInfo.getTransactionType())) {
			savedAcctInfo = bankService.deposit(acctInfo);
		} else if ("withdraw".equals(acctInfo.getTransactionType())) {
			savedAcctInfo = bankService.withdraw(acctInfo);
		}
		// I am passing my View Name
		ModelAndView mav = new ModelAndView("accountSummary");

		// Passing saved acctInfo Pojo class to map with view
		mav.addObject("acctInfo", savedAcctInfo);

		return mav;
	}

}
