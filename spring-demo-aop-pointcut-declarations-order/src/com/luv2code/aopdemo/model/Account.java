package com.luv2code.aopdemo.model;

public class Account {
	
	String name;
	
	public String getName() {
		System.out.println(getClass() + ">>> Getting name");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass() + ">>> Setting name");
		this.name = name;
	}
}
