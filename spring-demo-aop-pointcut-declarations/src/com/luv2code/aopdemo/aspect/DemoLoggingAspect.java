package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void DaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void DAOgetter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void DAOsetter() {}
	
	@Pointcut("DaoPackage() && !(DAOgetter() || DAOsetter())")
	public void NoGetterAndSetter() {}
	
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount(com.luv2code.aopdemo.model.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println(getClass()+"@Before AccountDAO.addAccount()");
	}
	
	@Before("NoGetterAndSetter()")
	public void beforeAddMethod() {
		System.out.println(getClass()+"@Before any DAO method");
	}
	
}
