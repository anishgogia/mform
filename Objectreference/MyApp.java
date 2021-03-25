package Objectreference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring9.xml");
 
        ICoach iCoach1 = (ICoach)context.getBean("BCoach1");
        ICoach iCoach2 = (ICoach)context.getBean("BCoach2");
 
        System.out.println((iCoach1.getDailyWorkout()));
        System.out.println(iCoach2.getFortune());
 
        System.out.println(iCoach1.toString());
        System.out.println(iCoach2.toString());
 
        ApplicationContext context2 = new ClassPathXmlApplicationContext("SetterSpring.xml");
 
        ICoach iCoach3 = (ICoach)context2.getBean("BCoach");
 
 
        System.out.println((iCoach3.getDailyWorkout()));
 
 
        System.out.println(iCoach3.toString());
 
 
    }
}

