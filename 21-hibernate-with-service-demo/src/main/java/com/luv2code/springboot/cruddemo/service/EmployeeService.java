package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee emp);
    public void deleteById(int id);
}
