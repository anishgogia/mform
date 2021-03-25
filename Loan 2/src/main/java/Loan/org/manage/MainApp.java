package Loan.org.manage;



import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String redo = "y";
		int input;
		String input2 = "";

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Scanner inp = new Scanner(System.in);
		Scanner inp1 = new Scanner(System.in);

		while (redo.equalsIgnoreCase("y")) {

			System.out.println("For New User Press 1");
			System.out.println("For New Existing User Press 2");
			System.out.println("For Press 3 To Skip To End");

			input = inp.nextInt();
			switch (input) {
			case 1:

				ICustomer cust = (Customer) context.getBean("cust");
				Address add = (Address) context.getBean("add");
				LoanReq loan = (LoanReq) context.getBean("loanreq");

				ILoanProcess loanProcess = (LoanProcess) context.getBean("loan");
				IIOOperation io = (IOOperation) context.getBean("io");

				System.out.println("Enter Your FullName");
				cust.setFullName(inp.next());
				System.out.println("Enter Your Age");
				cust.setAge(inp.nextInt());
				System.out.println("Enter Your Email");
				cust.setEmail(inp.next());
				System.out.println("Enter Your Hno: ");
				add.setHno(inp.next());

				System.out.println("Enter Your City: ");
				add.setCity(inp.next());

				System.out.println("Enter Your State: ");
				add.setState(inp.next());

				System.out.println("Enter your Phone Number: ");
				cust.setPhone(inp.nextInt());

				System.out.println("Enter kind of loan required: ");
				loan.setKind(inp.next());

				System.out.println("Enter amount of loan required: ");
				loan.setAmount(inp.nextInt());

				System.out.println("Your app no. is: " + loanProcess.generate(cust));

				System.out.println("Enter Income");
				cust.setIncome(inp.nextDouble());
				System.out.println("Enter AssetValue");
				cust.setAssetValue(inp.nextDouble());
				System.out.println("Enter Liability");
				cust.setLiabilityValue(inp.nextDouble());

				loanProcess.trueIncome(cust);

				System.out.println("What is Your Aadhar No");
				cust.setAadhar(inp.nextLong());
				System.out.println("What is Your PAN No");
				cust.setPan(inp1.next());

				loanProcess.setInfo(cust);

				try {
					if (!loanProcess.checkValdity()) {
						System.out.println("All personal details verified");
						loanProcess.setInfo(cust);
						double score = loanProcess.getScore();
						System.out.println("Credit Score: " + score);
						if (score > 20d) {
							System.out.println("Loan Approved");
							io.write(cust, loanProcess, add, loan);
						} else
							System.out.println("Application Rejected Because Of low credit score");
					} else {
						System.out.println("Application Rejected Because Of discrepancies in Personal Info");
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.println("Enter Your Application Number");
				input2 = inp.next();
				IIOOperation io1 = (IOOperation) context.getBean("io");
				io1.read(input2);
				break;

			case 3:
				((ClassPathXmlApplicationContext) context).close();
				break;
			}

			System.out.println("Enter 'y' to continue or enter any other key to exit.");
			redo = inp1.next();

		}
		inp.close();
		inp1.close();
	}

}
