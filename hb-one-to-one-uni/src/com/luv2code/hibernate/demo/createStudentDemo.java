package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class createStudentDemo {

	public static void main(String[] args) {
		
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		
		try {
			System.out.println("Creating new test student...");
			Student newStudent = new Student(args[0], args[1], args[2]);
			
			session.beginTransaction();
			System.out.println("Saving new student...");
			session.save(newStudent);
			
			System.out.println("New student info:");
			
			System.out.println("newStudent id: " + newStudent.getId());
			
			 newStudent= session.get(Student.class, newStudent.getId());
			
			System.out.println("Modifying student info...");
			
			newStudent.setEmail("prueba2@gmail.com");
			
			session.save(newStudent);
			System.out.println("Deleting first test student...");
			
			session.delete(newStudent);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

			
			

	}

}
