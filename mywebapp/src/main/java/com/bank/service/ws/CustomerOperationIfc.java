package com.bank.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.bank.persistance.model.Customer;

//@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CustomerOperationIfc {
	
	//@WebMethod
	public Customer getCustomer(String userName);

}
