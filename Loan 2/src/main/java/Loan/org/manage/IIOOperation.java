package Loan.org.manage;

import java.sql.SQLException;

public interface IIOOperation {

	public void read(String appNo) throws ClassNotFoundException, SQLException;

	public void write(ICustomer ic, ILoanProcess il, Address add, LoanReq loan) throws ClassNotFoundException, SQLException;

}
