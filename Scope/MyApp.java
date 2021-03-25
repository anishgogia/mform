package Scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class MyApp {
    public static void main(String[] args) {
 
        ApplicationContext context2 = new ClassPathXmlApplicationContext("SetterSpring.xml");
 
        ICoach iCoach3 = (ICoach)context2.getBean("BCoach");
 
 
        System.out.println((iCoach3.getDailyWorkout()));
 
 
        System.out.println(iCoach3.toString());
 
 
    }
}

