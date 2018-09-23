package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		//Create new student
		Student student = new Student();
		//Add student to the model
		model.addAttribute("student", student);
		model.addAttribute("theCountryOptions", countryOptions); 
		return "register-student-form";
	}
	
	@RequestMapping("/processForm")
	public String confirmStudent(@ModelAttribute("student") Student newStudent) {
		System.out.println("newStudent.getFirstName: "+ newStudent.getFirstName());
		return "student-confirmation";
	}
	
}
