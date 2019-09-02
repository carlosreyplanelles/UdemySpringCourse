package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Session session  = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session session  = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee emp) {
        Session session  = entityManager.unwrap(Session.class);
        session.saveOrUpdate(emp);
    }

    @Override
    public void deleteById(int id) {
        Session session  = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
    }
}
