package com.bank.persistance.dao;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.persistance.model.TransactionHistory;
@Transactional
@Repository("transactionDao")
public class TransactionHistoryDaoImpl  implements TransactionHistoryDaoIfc{

	@Autowired
	SessionFactory sessionFactory;
	
	int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public void save(TransactionHistory transaction) {
		try {

			int i = getRandomNumberInRange(1000, 99999999);

			Session session = sessionFactory.getCurrentSession();
			transaction.setTransactionId(i);;

			session.save(transaction);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionHistory> getTransactionList(int acctNo) {

		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from TransactionHistory t where t.acctNo=:acctNo");
		q.setParameter("acctNo", acctNo); 
		
		
		return q.list();
	}
}
