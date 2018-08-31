package com.bank.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bank.persistance.dao.CustomerDaoIfc;
import com.bank.persistance.model.Customer;

//@Component
@WebService
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public class CustomerOperation extends SpringBeanAutowiringSupport{
	
	@Autowired
	// LoginDaoIfc loginDao;
	CustomerDaoIfc customerDao; 

	@WebMethod
	public Customer getCustomer(String userName) {
		// TODO Auto-generated method stub

		if(customerDao !=null) {
			System.out.println("Dao injected");
		}else {
			System.out.println("Dao not injected");
		}
		Customer cust = new Customer();
		cust.setUsername(userName);
		cust.setFirstName("Robert");
		cust.setLastName("Aa");
		cust.setAcctNo(1234);

		return cust;
	}

}
