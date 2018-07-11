package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		/**
		 * If I create an instance of coach instead of TennisCoach i can't access to the public methods implemented in TennisCoach class.
		 * Coach tennisCoach = context.getBean("tennisCoach", Coach.class)
		 */
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		
		// call a method on the bean
		System.out.println("TennisCoach workout: " + tennisCoach.getDailyWorkout());
		System.out.println("BaseballCoach workout: "+ baseballCoach.getDailyWorkout());
		
		//call method get the daily fortune
		System.out.println("TennisCoach daily fortune: " + tennisCoach.getDailyFortune());
		System.out.println("TennisCoach team: "+tennisCoach.getTeam());
		
		// close the context
		context.close();

	}

}
