package com.luv2code.aopdemo.model;

public class Account {
	
	String name;
	
	public Account(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + "]";
	}
}
