package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;


public interface CustomerService {
	
	@Transactional
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
