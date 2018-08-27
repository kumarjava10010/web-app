package com.bank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.persistance.dao.AcctInfoDaoIfc;
import com.bank.persistance.dao.CustomerDaoIfc;
import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.Customer;
import com.bank.persistance.model.CustomerValidator;

@Controller
public class CustomerController {

	@Autowired
	// LoginDaoIfc loginDao;
	CustomerDaoIfc customerDao;

	@Autowired
	AcctInfoDaoIfc acctInfoDao;
	
	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
		binder.addValidators(new CustomerValidator());

		// You can create your custom validator class and add it here
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView customerAction(HttpServletRequest request, HttpServletResponse response) {

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("register");

		// Passing new LoginUser Pojo class to map with view
		mav.addObject("customerObject", new Customer());

		return mav;
	}

	@RequestMapping(value = "/customerSave", method = RequestMethod.POST)
	public ModelAndView customerSave(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customerObject") @Validated Customer customer, BindingResult result) {

		// validator.validate(customer, result);

		if (result.hasErrors()) {
			return new ModelAndView("register");
		}

		if (customer.getAcctNo() == null) {

			int acctNo = customerDao.save(customer);
			
			AcctInfo acctInfo = new AcctInfo();
			acctInfo.setAcctNumber(acctNo);
			acctInfo.setAcctType("C");
			acctInfo.setBalance("0.0");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(new Date()); 
			acctInfo.setLastupdateddate(date);
			acctInfo.setLastupdatedby(customer.getUsername());
			
			acctInfoDao.save(acctInfo);

		} else {
			customerDao.update(customer);

		}
		// I am passing my welcome View Name
		ModelAndView mav = new ModelAndView("welcome");

		// Passing customer object from DB to View
		mav.addObject("customer", customer);

		return mav;
	}

}
