package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;

public class createDemo {

	public static void main(String[] args) {
		
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Chad", "Derby", "chad@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("youtubeChan", "hobby");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			System.out.println("Saving Instructor: " + instructor.toString());
			session.save(instructor);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

			
			

	}

}
