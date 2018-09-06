package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
public interface FortuneService {
	
	public String getFortune();
}
