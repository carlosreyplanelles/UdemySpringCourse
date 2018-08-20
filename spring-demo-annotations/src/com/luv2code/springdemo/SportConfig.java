package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//define a bean for our happy fortune service
	@Bean
	public FortuneService HappyFortuneService() {
		return new HappyFortuneService();
	}
	
	//define bean for oir swim coach AND inject dependency
	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach(HappyFortuneService());
	}
	
}
