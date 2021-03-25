package com.ncu.AOPdemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Pointcut("execution(* addAccount(..))")
	private  void forDaoPackage() {
		
		//System.out.println("Executing  advice on addAccount()");
		
	}
	@Before("forDaoPackage()")
	public void before(){
		System.out.println("in before");
	}
	
}