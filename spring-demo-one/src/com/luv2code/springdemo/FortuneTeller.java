package com.luv2code.springdemo;

import java.util.Random;

public class FortuneTeller implements FortuneService {
	
	String[] fortuneArray = {"Today is an average day. Nothing interesting will happen.",
	                         "Today is your lucky day!",
	                         "Today is not your day. Be careful!"};
	@Override
	public String getFortune() {
		Random rand = new Random();
		int index = rand.nextInt(fortuneArray.length);
		return fortuneArray[index];
	}

}
