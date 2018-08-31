package com.bank.restful;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.persistance.model.AccountJson;
import com.bank.persistance.model.AcctInfo;
import com.bank.service.BankServiceIfc;

@RestController
public class CustomerRestController {

	@Autowired
	BankServiceIfc bankService; // Service which will do all data retrieval/manipulation work

	@RequestMapping(value = "/acctJSONApi/{acctNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountJson> getAcctSummaryJSON(@PathVariable("acctNumber") int acctNumber) throws IllegalAccessException, InvocationTargetException {

		System.out.println("Fetching User with id " + acctNumber);

		AcctInfo acctInfo = bankService.getAcctSummary(acctNumber);

		if (acctInfo == null) {
			System.out.println("User with id " + acctNumber + " not found");
			return new ResponseEntity<AccountJson>(HttpStatus.NOT_FOUND);
		}
		
		
		AccountJson newAcctInfo = new AccountJson();
		BeanUtils.copyProperties(newAcctInfo, acctInfo);
		
		System.out.println("BankREstController : "+newAcctInfo.toString());


		return new ResponseEntity<AccountJson>(newAcctInfo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/acctTextApi/{acctNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAcctSummaryText(@PathVariable("acctNumber") int acctNumber) throws IllegalAccessException, InvocationTargetException {

		System.out.println("Fetching User with id " + acctNumber);

		AcctInfo acctInfo = bankService.getAcctSummary(acctNumber);

		if (acctInfo == null) {
			System.out.println("User with id " + acctNumber + " not found");
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		
		AccountJson newAcctInfo = new AccountJson();
		
		BeanUtils.copyProperties(newAcctInfo, acctInfo);
		
		System.out.println("BankREstController : "+newAcctInfo.toString());


		return new ResponseEntity<String>(newAcctInfo.toString(), HttpStatus.OK);
	}

}