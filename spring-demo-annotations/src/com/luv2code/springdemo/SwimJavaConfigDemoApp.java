package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		/**
		 * If I create an instance of coach instead of TennisCoach i can't access to the public methods implemented in TennisCoach class.
		 * Coach tennisCoach = context.getBean("tennisCoach", Coach.class)
		 */
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		
		// call a method on the bean
		System.out.println("SwimCoach workout: " + swimCoach.getDailyWorkout());
		//System.out.println("BaseballCoach workout: "+ baseballCoach.getDailyWorkout());
		
		//call method get the daily fortune
		System.out.println("SwimCoach daily fortune: " + swimCoach.getDailyFortune());
		
		//Call getter team and email
		System.out.println("swimCoach >> Email: " + swimCoach.getEmail());
		System.out.println("swimCoach >> Team: " + swimCoach.getTeam());
		
		// close the context
		context.close();

	}

}
