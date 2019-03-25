package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO{
	
	public List<Customer> getCustomers();
	public void save(Customer customer);
	public Customer getCustomer(int id);
	public boolean deleteCustomer(int id);
	public List<Customer> searchCustomers(String name);
}