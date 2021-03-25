package com.ncu.AOPdemo;

import org.springframework.stereotype.Component;

@Component("accountDao")
public class AccountDao {
    String AccountName;
	public String getAccountName() {
		return AccountName ;
	}
	public void setAccountName(String anish)
	{
		System.out.println("in setter");
		AccountName = anish;
	}
	public void addAccount() {
		System.out.println("in acc add");
	}
}