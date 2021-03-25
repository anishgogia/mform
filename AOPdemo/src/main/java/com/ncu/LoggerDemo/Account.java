package com.ncu.LoggerDemo;
import org.springframework.stereotype.Component;

@Component("account")
public class Account {
	public void print() {
		System.out.println("A Class Print");
	}
}
