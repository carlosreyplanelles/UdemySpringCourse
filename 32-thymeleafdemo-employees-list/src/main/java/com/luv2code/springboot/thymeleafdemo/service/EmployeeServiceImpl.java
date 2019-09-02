package com.luv2code.springboot.thymeleafdemo.service;


import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee result = null;
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new RuntimeException("Did not find employee - "+id);
        }
    }

    @Override
    public void save(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
