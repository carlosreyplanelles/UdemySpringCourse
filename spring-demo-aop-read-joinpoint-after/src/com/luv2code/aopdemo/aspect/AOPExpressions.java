package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPExpressions {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void DAOPackage() {}
	
	@Pointcut("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount(com.luv2code.aopdemo.model.Account))")
	public void ADDAccount() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.AccountDAO.getAccounts(..))")
	public void GetAccounts() {}
}
