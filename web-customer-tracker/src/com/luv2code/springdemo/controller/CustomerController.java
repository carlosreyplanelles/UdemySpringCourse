package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String listCustomer(Model theModel) {
		
		//Get custmomers from DAO
		List<Customer> customers = customerService.getCustomers();
		//Add customers to the model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}

}
