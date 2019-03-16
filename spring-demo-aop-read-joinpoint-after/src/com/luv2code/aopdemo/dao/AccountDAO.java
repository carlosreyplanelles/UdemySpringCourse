package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.model.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() +": ADDING AN ACCOUNT\n");
	}
	
	public List<Account> getAccounts(){
		
		Account account1 = new Account("John");
		Account account2 = new Account("Peter");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		
		return accounts;
	}

}
