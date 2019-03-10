package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
	
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount(com.luv2code.aopdemo.model.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println(getClass()+"@Before AccountDAO.addAccount()");
	}
	
}
