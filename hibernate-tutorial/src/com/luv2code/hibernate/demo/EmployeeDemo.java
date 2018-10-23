package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.Employee;

public class EmployeeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Employee insertEmployee = new Employee("Luis","Gonzalez", "Ericsson");
		Employee deleteEmployee = new Employee("Antonio", "Martinez", "Ericsson");
		
		try {
			session.beginTransaction();
			
			session.save(insertEmployee);
			System.out.println("Employee-Create >> " + insertEmployee.toString() + " inserted");
			session.save(deleteEmployee);
			deleteEmployee = session.get(Employee.class, deleteEmployee.getId());
			System.out.println("Employee-Create >> " + deleteEmployee.toString() + " inserted");
			
			insertEmployee.setFirstName("Fernando");
			insertEmployee.setLastName("Moran");
			insertEmployee.setCompany("TELCO");
			
			System.out.println(insertEmployee.toString());
			session.save(insertEmployee);
			System.out.println("Employee-Update >> "+ insertEmployee.toString() + " data updated");
			
			session.delete(deleteEmployee);
			System.out.println("Employee-Delete >> " + insertEmployee.toString() + " deleted");
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		

	}

}
