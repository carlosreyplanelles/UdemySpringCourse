package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.model.Account;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AOPExpressions.ADDAccount()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println(getClass()+" @Before AccountDAO.addAccount()");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+ signature);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object arg:args) {
			System.out.println(arg);
		}
	}
	
	@After("com.luv2code.aopdemo.aspect.AOPExpressions.ADDAccount()")
	public void AfterAddAccount(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println(getClass() + " >>>>> @After " + signature);
		System.out.println("Method: "+ signature);
	}
	
	@AfterReturning(
			pointcut="com.luv2code.aopdemo.aspect.AOPExpressions.GetAccounts()",
			returning="accounts")
	public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> accounts) {
		String method =joinPoint.getSignature().toShortString();
		System.out.println(getClass() +">>>>> " + method);
		System.out.println(getClass() + ">>>>> Accounts: "+ accounts);
		toUopperCase(accounts);
		
		
		
	}
	
	@After("com.luv2code.aopdemo.aspect.AOPExpressions.GetAccounts()")
	public void AfterFindAccounts(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println(getClass() + " >>>>> @After " + signature);
		System.out.println("Method: "+ signature);
	}

	private void toUopperCase(List<Account> accounts) {
		accounts.stream().forEach(account->{
			String name = account.getName().toUpperCase();
			account.setName(name);
		});
		
	}
	
}
