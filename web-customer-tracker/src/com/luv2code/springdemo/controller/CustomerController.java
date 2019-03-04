package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String listCustomer(Model model) {
		
		//Get custmomers from DAO
		List<Customer> customers = customerService.getCustomers();
		//Add customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showAddCustomerForm")
	public String AddCustomerForm(Model model) {
		Customer newCustomer = new Customer();
		
		model.addAttribute("customer", newCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:/customer/";
	}
	
	@GetMapping("/updateForm")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id ) {
		
		customerService.deleteCustomer(id);
		return "redirect:/customer/";
	}
	
	  @GetMapping("/search")
	    public String searchCustomers(@RequestParam("firstName") String firstName, Model theModel) {
	        List<Customer> theCustomers = customerService.searchCustomers(firstName);
	        theModel.addAttribute("customers", theCustomers);

	        return "list-customers";        
	    }
	
	
}
