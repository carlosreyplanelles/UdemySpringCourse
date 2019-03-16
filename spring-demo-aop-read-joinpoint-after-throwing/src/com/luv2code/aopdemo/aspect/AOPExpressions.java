package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPExpressions {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void DAOPackage() {}
}
