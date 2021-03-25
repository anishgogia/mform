package com.ncu.employeelab;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
    			System.out.println("---before main call----");
    			// get the bean from spring container
    			Employee emp =context.getBean("accountDao",Employee.class);
    		     emp.setName("anish gogia");
    		     emp.calculate_sal();
    			System.out.println(emp.getName());

    			
    			context.close();
    }
}
