package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void save(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public boolean deleteCustomer(int id) {
		boolean borrado = false;
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			session.delete(customer);
			borrado = true;
		}
		return borrado;
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("FROM Customer WHERE firstName = :firstname")
				.setParameter("firstname", name);

		List<Customer> filteredCustomers = query.getResultList();
		return filteredCustomers;
	}
}
