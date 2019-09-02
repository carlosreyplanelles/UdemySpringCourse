package com.luv2code.springboot.thymeleafdemo.dao;


import com.luv2code.springboot.thymeleafdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
