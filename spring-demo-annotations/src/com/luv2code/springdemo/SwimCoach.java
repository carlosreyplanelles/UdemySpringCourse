package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SwimCoach(FortuneService happyFortuneService) {
		fortuneService  = happyFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 metres";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
