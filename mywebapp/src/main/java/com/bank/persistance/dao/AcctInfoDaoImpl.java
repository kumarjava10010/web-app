package com.bank.persistance.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.persistance.model.AcctInfo;

@Repository("acctInfoDao")
@Transactional
public class AcctInfoDaoImpl implements AcctInfoDaoIfc {

	final static Logger logger = Logger.getLogger(AcctInfoDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public void save(AcctInfo account) {

		logger.info("***** AcctInfoDaoImpl | Save | Start| ");

		Session session = null;

		try {
			session = sessionFactory.getCurrentSession();
			session.save(account);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("AcctInfoDaoImpl Save Error : " + e.getMessage());
		} finally {
		}

		logger.info("***** AcctInfoDaoImpl | Save | END| ");
	}

	public void update(AcctInfo account) {

		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			
			session.update(account);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("AcctInfoDaoImpl Save Error : " + e.getMessage());
		}
	}

	public void delete(AcctInfo account) {
		// getHibernateTemplate().delete(account);

	}

	public AcctInfo findByAcctNumber(int acctNumber) {
		logger.info("***** AcctInfoDaoImpl | findByAcctNumber | Start| ");

		Session session = null;
		AcctInfo acctInfo = null;
		try {
			session = sessionFactory.openSession();
			acctInfo = (AcctInfo) session.get(AcctInfo.class, acctNumber);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Account Info Error : " + e.getMessage());
		} finally {
			session.close();
		}

		logger.info("***** AcctInfoDaoImpl | findByAcctNumber | END| ");

		return acctInfo;
	}

}
