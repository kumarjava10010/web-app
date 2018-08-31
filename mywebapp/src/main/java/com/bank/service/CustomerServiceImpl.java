package com.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.persistance.dao.AcctInfoDaoIfc;
import com.bank.persistance.dao.CustomerDaoIfc;
import com.bank.persistance.model.AcctInfo;
import com.bank.persistance.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerServiceIfc {

	@Autowired
	// LoginDaoIfc loginDao;
	CustomerDaoIfc customerDao;

	@Autowired
	AcctInfoDaoIfc acctInfoDao;

	@Override
	public Customer createCustomer(Customer customer) {

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

		customer.setAcctNo(acctNo);

		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customerDao.update(customer);

		return customer;
	}

}
