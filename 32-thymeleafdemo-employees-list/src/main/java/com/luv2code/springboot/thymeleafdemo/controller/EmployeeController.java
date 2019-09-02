package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.model.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmpoloyees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-add-form";
    }

    @GetMapping("/showUpdateForm")
    public String showAddForm(Model model, @RequestParam("id") int id){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee-update-form";
    }


    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
