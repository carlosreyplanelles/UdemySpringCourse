package com.luv2code.springdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Customer;



@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void controllerPackage() {}
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void servicePackage() {}
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void daoPackage() {}
	@Pointcut("controllerPackage() || servicePackage() || daoPackage()")
	private void appFlow() {}
	
	@Before("appFlow()")
	public void before(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().toShortString();
		myLogger.info("["+ getClass()+ "] =====> "+ method);
		Object[] args = joinpoint.getArgs();
		
		if(args.length > 0) {
			for (Object arg: args) {
				myLogger.info(arg.toString());
			}
		}
	}
	@AfterReturning(pointcut= "appFlow()", returning="customers")
	public void afterReturning(JoinPoint joinpoint, List<Customer> customers) {
		String method = joinpoint.getSignature().toShortString();
		myLogger.info("[" + getClass() + "] =====> "+ method);
		myLogger.info("[" + getClass() + "] =====> return: "+ customers);
	}

}
