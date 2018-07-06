package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	@PostConstruct
	public void doConstructStuff() {
		System.out.println(">>Inside doConstructStuff()");
	}
	
	// create an array of strings
	@Value("${fortune.fortunes}")
	  private String[] data;
	
	// create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random string from array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune;
	}

}
