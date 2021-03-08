package DAO;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class Application {
	    public static void main(String[] args) {
	        ApplicationContext context = new ClassPathXmlApplicationContext("spring3.xml");
	        System.out.println("MY SQL OPERATIONS");
	        Operations op = (Operations)context.getBean("mySqlDao");
	        op.create();
	        op.delete();
	        //anish 19csu029
	        op.read();
	        op.update();
	        System.out.println();
	        System.out.println("ORACLE OPERATIONS");
	        Operations op2 = (Operations)context.getBean("oracleDao");
	        op2.create();
	        //anish 19csu029
	        op2.delete();
	        op2.read();
	        op2.update();
	        System.out.println();
	        System.out.println("POS GRES OPERATIONS");
	        Operations op3 = (Operations)context.getBean("postgresDao");
	        op3.create();
	        op3.delete();
	        op3.read();
	        op3.update();
	    }
	}


