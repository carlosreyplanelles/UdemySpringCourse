package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
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
	
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount(com.luv2code.aopdemo.model.Account))")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println(getClass()+"@Before AccountDAO.addAccount()");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+ signature);
		
		Object[] args = joinPoint.getArgs();
		
		for(Object arg:args) {
			System.out.println(arg);
		}
	}
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.getAccounts(..))",returning="accounts")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
		String method =joinPoint.getSignature().toShortString();
		System.out.println(getClass() +">>>>> " + method);
		System.out.println(getClass() + ">>>>> Accounts: "+ accounts);
		toUopperCase(accounts);
		
		
		
	}

	private void toUopperCase(List<Account> accounts) {
		accounts.stream().forEach(account->{
			String name = account.getName().toUpperCase();
			account.setName(name);
		});
		
	}
	
}
