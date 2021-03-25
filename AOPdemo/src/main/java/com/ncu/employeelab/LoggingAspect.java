package com.ncu.employeelab;

import java.util.ArrayList;
import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect{
	
@Pointcut("execution(* com.ncu.employeelab.Employee.setName(String))")
private void onSetter() {}


@Pointcut("execution(* com.ncu.employeelab.Employee.getName())")
private void ongetter() {}	


@Pointcut("execution(* com.ncu.employeelab.Employee.calculate_sal())")
private void aroundcal_sal() {}


	@Before("onSetter()")
	public void beforeAddAccountAdvice(JoinPoint jp) {
		System.out.println("\n Executing advice on setter ");
		ArrayList<MethodSignature> ms= new ArrayList<MethodSignature>();
		ms.add((MethodSignature)jp.getSignature());
		Iterator<MethodSignature> itr=ms.iterator(); 
		  while(itr.hasNext()) {
			  System.out.println(itr.next()) ;
		  }
	} 
		  
	  @Before("ongetter()")
		public void beforeAccountAdvice(JoinPoint jp) {
			System.out.println("\n Executing advice on getter ");
				ArrayList<MethodSignature> ms= new ArrayList<MethodSignature>();
				ms.add((MethodSignature)jp.getSignature());
				Iterator<MethodSignature> itr=ms.iterator(); 
				  while(itr.hasNext()) {
					  System.out.println(itr.next());
				  }
				  
		  }
		@Around("aroundcal_sal()")
					public void beforeAdvice(JoinPoint jp) {
						System.out.println("\n Executing advice around calculate salary ");
						ArrayList<MethodSignature> ms= new ArrayList<MethodSignature>();
						ms.add((MethodSignature)jp.getSignature());
						Iterator<MethodSignature> itr=ms.iterator(); 
						  while(itr.hasNext()) {
							  System.out.println(itr.next());
						  }
	}
}
