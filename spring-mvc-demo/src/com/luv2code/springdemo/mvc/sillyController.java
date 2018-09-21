package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/silly")
public class sillyController {
	
	//Initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}
	
	//Result
	@RequestMapping("/showHello")
	public String showHello() {
		return "helloworld";
	}
	
	
	@RequestMapping("/helloShout")
	public String ShoutHello(HttpServletRequest request, Model m)
	{
		//Read request from HTML form
		String theName = request.getParameter("studentName");
		
		//Convert to upperCase
		theName=theName.toUpperCase();
		
		//Add name to the model
		m.addAttribute("name", theName);
		return("helloworld");
	}
	
	@RequestMapping("/helloShout2")
	public String ShoutHello2(@RequestParam("studentName") String theName, Model m)
	{
		//Convert to upperCase
		theName="RquestParam: "+ theName.toUpperCase();
		
		//Add name to the model
		m.addAttribute("name", theName);
		return("sillyworld");
	}
}
