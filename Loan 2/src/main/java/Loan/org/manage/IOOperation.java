package Loan.org.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import org.springframework.stereotype.Component;



@Component("io")
public class IOOperation implements IIOOperation {

	@Override
	public void read(String appNo) throws ClassNotFoundException, SQLException {

		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mform","root","ishaan@123");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from cust where appnum = '" + appNo + "'");

		System.out.println(
				"Name\t|\tAddress\t|\tEmail\t|\tLoan Type\t|\tPhone Number\t|\tAge\t|\tAadhar\t|\tPan\t|\tScore\t|\tApp Num\t|\tTrue Income");
		while (rs.next()) {
			System.out.println(rs.getString("name") + "\t|\t" + rs.getString("address") + "\t|\t"
					+ rs.getString("email") + "\t|\t" + rs.getString("loantype") + rs.getInt("phone") + rs.getInt("age")
					+ rs.getLong("aadhar") + rs.getString("pan") + rs.getDouble("score") + rs.getString("appnum")
					+ rs.getDouble("trueIncome"));
		}

		rs.close();
		stmt.close();
		con.close();
	}

	public void write(ICustomer ic, ILoanProcess il, Address add, LoanReq loan) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mform","root","ishaan@123");

		Statement stmt = con.createStatement();

		String query = "insert into cust values('" + ic.getFullName() + "', '" + ic.getAddress(add) + "', '"
				+ ic.getEmail() + "', '" + ic.getLoan(loan) + "', " + ic.getPhone() + ", " + ic.getAge() + ", "
				+ ic.getAadhar() + ", '" + ic.getPan() + "', " + il.getScore() + ", '" + il.generate(ic) + "', "
				+ il.trueIncome(ic) + ")";

		int insert = stmt.executeUpdate(query);

		if (insert == 1) {
			System.out.println("Successfull :)");
		} else
			System.out.println("Fail :(");

		stmt.close();
		con.close();
	}

}
