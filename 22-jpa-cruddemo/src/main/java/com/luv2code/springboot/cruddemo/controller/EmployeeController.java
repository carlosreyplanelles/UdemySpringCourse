package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.model.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) throws Exception {
        Employee emp = employeeService.findById(id);
        if(emp == null){
            throw new RuntimeException("Employee not found - " + id);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee emp){
        emp.setId(0);
        employeeService.save(emp);
        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        employeeService.save(emp);
        return emp;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee emp = employeeService.findById(id);
        if(emp == null){
            throw new RuntimeException("Employee not found - " + id);
        }
        employeeService.deleteById(id);
    }


}
