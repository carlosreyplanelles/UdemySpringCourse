package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class APIAnalyticsAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void DAOPackage() {}
	
	@Before("DAOPackage()")
	public void APIAnalyticsAdvice() {
		System.out.println(getClass()+": API Analytics advice");
	}
}
