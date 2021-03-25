package Loan.org.manage;

import java.sql.SQLException;

public interface ILoanProcess {

	public void setInfoForScore(ICustomer ic);

	public double getScore();

	public void setInfo(ICustomer ic);

	public boolean checkValdity() throws ClassNotFoundException, SQLException;

	public String generate(ICustomer ic);

	public double trueIncome(ICustomer ic);
}
