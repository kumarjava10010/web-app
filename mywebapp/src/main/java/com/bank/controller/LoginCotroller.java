package com.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.persistance.dao.CustomerDaoIfc;
import com.bank.persistance.model.Customer;
import com.bank.persistance.model.LoginUser;

@Controller
public class LoginCotroller {
	
	@Autowired
	//LoginDaoIfc loginDao;
	CustomerDaoIfc customerDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {

		// I am passing my View Name
		ModelAndView mav = new ModelAndView("login");

		// Passing new LoginUser Pojo class to map with view
		mav.addObject("loginUser", new LoginUser());

		return mav;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginUser") LoginUser login) {

		ModelAndView mav = null;
		
		
		
		Customer customer = customerDao.authenticate(login);

		if (customer !=null) {
			
			System.out.println("Authentication Success ");
			// If log in Success, it will redirect to welcome.jsp
			mav = new ModelAndView("welcome");

			// this is data to display in your welcome jsp
			mav.addObject("firstname", customer.getUsername());
			mav.addObject("customer", customer);
		} else {

			mav = new ModelAndView("loginUser");
			mav.addObject("loginFailed", "Username or Password is wrong!!");
		}

		return mav;
	}

}
