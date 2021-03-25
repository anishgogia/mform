package com.ncu.Annotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring7.xml");
    	CricketCoach cricket=(CricketCoach)ac.getBean("ccoach",CricketCoach.class);
    	
    	System.out.println(cricket.getDailyWorkout());
    	System.out.println(cricket.getDailyFortune());
TennisCoach tennis=(TennisCoach)ac.getBean("tcoach",TennisCoach.class);
    	
    	System.out.println(tennis.getDailyWorkout());
    	System.out.println(tennis.getDailyFortune());
    	
    	
    }
    }

