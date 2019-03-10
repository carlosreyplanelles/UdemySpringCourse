package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void DAOPackage() {}
	
	@Before("DAOPackage()")
	public void logToCloudAdvice() {
		System.out.println(getClass()+": Loging to cloud advice");
	}

}
