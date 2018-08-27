package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.persistance.dao.AcctInfoDaoIfc;
import com.bank.persistance.dao.CustomerDaoIfc;
import com.bank.persistance.dao.TransactionHistoryDaoIfc;
import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.Customer;
import com.bank.persistance.model.TransactionHistory;

@Controller
public class WelcomeController {

	@Autowired
	// LoginDaoIfc loginDao;
	CustomerDaoIfc customerDao;

	@Autowired
	AcctInfoDaoIfc acctInfoDao;
	
	@Autowired
	TransactionHistoryDaoIfc transactionDao;

	@RequestMapping(value = "/customerAction", params = "updateProfile", method = RequestMethod.POST)
	public ModelAndView getCustomerDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer) {

		System.out.println("***** acctNo ****" + customer.getAcctNo());
		Customer existingCustomer = customerDao.findByAcctNumber(customer.getAcctNo());

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("register");

		// Passing existingCustomer object from DB for Edit profile
		mav.addObject("customerObject", existingCustomer);

		return mav;
	}

	@RequestMapping(value = "/customerAction", params = "accountSummary", method = RequestMethod.POST)
	public ModelAndView getAccountSummaryView(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer) {

		System.out.println("***** acctNo ****" + customer.getAcctNo());

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("accountSummary");

		AcctInfo acctInfo = acctInfoDao.findByAcctNumber(customer.getAcctNo());

		// Passing AcctInfo object from DB
		mav.addObject("acctInfo", acctInfo);

		return mav;
	}

	@RequestMapping(value = "/customerAction", params = "deposit", method = RequestMethod.POST)
	public ModelAndView getDepositView(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer) {

		System.out.println("***** acctNo ****" + customer.getAcctNo());

		AcctInfo acctInfo = acctInfoDao.findByAcctNumber(customer.getAcctNo());

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("depositWithdraw");

		// Passing AcctInfo object from DB
		mav.addObject("acctInfo", acctInfo);

		return mav;
	}

	@RequestMapping(value = "/customerAction", params = "transaction", method = RequestMethod.POST)
	public ModelAndView getTransactionView(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer) {

		System.out.println("***** acctNo ****" + customer.getAcctNo());

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("transactions");
		
		List<TransactionHistory> transactionList = transactionDao.getTransactionList(customer.getAcctNo());

		// Passing transactionHistory List object from DB
		mav.addObject("transactionHistory", transactionList);

		return mav;
	}

	@RequestMapping(value = "/customerAction", params = "home", method = RequestMethod.POST)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {

		// I am passing my Home View Name
		ModelAndView mav = new ModelAndView("home");

		return mav;
	}

}
