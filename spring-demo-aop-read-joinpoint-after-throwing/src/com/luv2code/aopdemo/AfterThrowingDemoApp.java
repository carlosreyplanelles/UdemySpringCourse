package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.model.Account;


public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

			AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
			List<Account> accounts = accountDAO.getAccounts();

			System.out.println("AfterThrowingDemoApp >>>> Display after returning");
			accounts = null;
			System.out.println(accounts);

			context.close();
		} catch (Exception e) {
			System.out.println("AfterThrowingDemoApp >>>> " + e.getMessage());
		}

	}

}
