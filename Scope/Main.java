package Scope;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanScope.xml");
 
        ICoach iCoach1 = (ICoach)context.getBean("BCoach");
        iCoach1.setName("anish gogia");
        ICoach iCoach2 = (ICoach)context.getBean("BCoach");
        iCoach2.setName("19csu029");
        System.out.println(iCoach1.getName());
        System.out.println(iCoach2.getName());
 
 
    }
}


