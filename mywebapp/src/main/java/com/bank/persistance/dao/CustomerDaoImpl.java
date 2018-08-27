package com.bank.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.persistance.model.Customer;
import com.bank.persistance.model.LoginUser;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDaoIfc {

	@Autowired
	SessionFactory sessionFactory;

	public int save(Customer customer) {
		int acctNumber = 0;
		try {

			String hql = "select max(customer.acctNo) from Customer customer";

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery(hql);
			List list = query.list();
			 acctNumber = (int) list.get(0);
			acctNumber = acctNumber + 1;
			customer.setAcctNo(acctNumber);
			session.save(customer);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  acctNumber;
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

	public Customer authenticate(LoginUser loginUser) {
		try {
			System.out.println("I am in DAO Class " + loginUser.getUsername());

			// String hql = "FROM LoginUser user WHERE user.username = :name AND
			// user.password = :pass";

			Session session = sessionFactory.getCurrentSession();

			Query query = session.getNamedQuery("authenticate");
			query.setParameter("user", loginUser.getUsername());
			query.setParameter("pass", loginUser.getPassword());

			List<Customer> results = query.list();

			if (results.isEmpty()) {
				System.out.println("I am in DAO Class Failed " + loginUser.getUsername());

				return null;

			} else {
				System.out.println("I am in DAO Class Success : " + loginUser.getUsername());

				return (Customer) results.get(0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
