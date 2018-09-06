package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FootballJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		/**
		 * If I create an instance of coach instead of TennisCoach i can't access to the public methods implemented in TennisCoach class.
		 * Coach tennisCoach = context.getBean("tennisCoach", Coach.class)
		 */
		FootballCoach footballCoach = context.getBean("footballCoach", FootballCoach.class);
		
		//Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		
		// call a method on the bean
		System.out.println("footBallCoach workout: " + footballCoach.getDailyWorkout());

		
		//call method get the daily fortune
		System.out.println("footballCoach daily fortune: " + footballCoach.getDailyFortune());
		
		//Call getter team and email
		System.out.println("footballCoach >> Email: " + footballCoach.getEmail());
		System.out.println("footballCoach >> Team: " + footballCoach.getTeam());
		
		// close the context
		context.close();

	}

}
