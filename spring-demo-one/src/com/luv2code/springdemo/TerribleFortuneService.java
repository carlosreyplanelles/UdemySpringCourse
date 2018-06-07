package com.luv2code.springdemo;

public class TerribleFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is not your day. Be careful!";
	}

}
