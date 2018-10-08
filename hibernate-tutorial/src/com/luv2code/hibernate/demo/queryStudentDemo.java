package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;

public class queryStudentDemo {

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
			List<Student> students = session.createQuery("from Student").list();
			displayStudents(students);
	
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

			
			

	}

	private static void displayStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println(student);
		}
	}

}
