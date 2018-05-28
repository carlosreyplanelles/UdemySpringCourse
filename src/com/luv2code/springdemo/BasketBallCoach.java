package com.luv2code.springdemo;

public class BasketBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BasketBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Improve your aim on 3 points shots";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
