package com.ncu.LoggerDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	      
		Account a = (Account)context.getBean("account",Account.class);
	    a.print();
	    //anish 19csu029 
//	    System.out.println("************************************");
//	       B b = (B)context.getBean("b", B.class);
//	       b.print2();
	       context.close();
	}

}
