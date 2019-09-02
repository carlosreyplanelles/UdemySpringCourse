package com.luv2code.springboot.thymeleafdemo.service;



import com.luv2code.springboot.thymeleafdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee emp);
    public void deleteById(int id);
}
