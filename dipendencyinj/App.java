package dipendencyinj;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springdi.xml");
        A a1 =(A)context.getBean("A");
        A a2 =(A)context.getBean("A");
 
 
    }
}

