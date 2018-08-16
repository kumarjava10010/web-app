package com.bank.persistance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.persistance.model.Customer;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDaoIfc {

	@Autowired
	SessionFactory sessionFactory;

	public void save(Customer customer) {
		try {

			Session session = sessionFactory.getCurrentSession();

			session.merge(customer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
	}

	public void delete(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	public Customer findByAcctNumber(int acctNumer) {
		
		Session session = sessionFactory.getCurrentSession();

		Customer cust = (Customer) session.get(Customer.class, acctNumer);
		return cust;
	}

}
