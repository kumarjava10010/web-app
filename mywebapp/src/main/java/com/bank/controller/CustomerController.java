package com.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.persistance.dao.CustomerDaoIfc;
import com.bank.persistance.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	// LoginDaoIfc loginDao;
	CustomerDaoIfc customerDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView customerAction(HttpServletRequest request, HttpServletResponse response) {

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("register");

		// Passing new LoginUser Pojo class to map with view
		mav.addObject("customer", new Customer());

		return mav;
	}
	
	@RequestMapping(value = "/getCustomerDetails", method = RequestMethod.GET)
	public ModelAndView getCustomerDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer) {

		System.out.println("***** acctNo ****"+customer.getAcctNo());
		Customer existingCustomer = customerDao.findByAcctNumber(1234);
		
		// I am passing my View Name
		ModelAndView mav = new ModelAndView("register");

		// Passing new LoginUser Pojo class to map with view
		mav.addObject("customer", existingCustomer);

		return mav;
	}
	
	

	@RequestMapping(value = "/customerSave", method = RequestMethod.POST)
	public ModelAndView customerSave(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("customer") Customer customer) {

		if (customer.getAcctNo() == null) {
			
			customerDao.save(customer);
		} else {
			customerDao.update(customer);

		}
		// I am passing my View Name
		ModelAndView mav = new ModelAndView("welcome");

		// Passing new LoginUser Pojo class to map with view
		mav.addObject("customer", customer);

		return mav;
	}
}
