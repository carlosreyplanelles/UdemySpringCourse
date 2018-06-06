package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		
		// call a method on the bean
		System.out.println("TennisCoach workout: " + tennisCoach.getDailyWorkout());
		System.out.println("BaseballCoach workout: "+ baseballCoach.getDailyWorkout());
		
		//call method get the daily fortune
		System.out.println("TennisCoach daily fortune: " + tennisCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
