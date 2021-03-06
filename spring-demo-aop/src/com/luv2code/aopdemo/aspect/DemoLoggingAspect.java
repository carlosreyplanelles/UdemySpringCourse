package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println(getClass()+"@Before AccountDAO.addAccount()");
	}
	
	@Before("execution(* add*())")
	public void beforeAddMethod() {
		System.out.println(getClass()+"@Before any add method and any return type");
	}
}
