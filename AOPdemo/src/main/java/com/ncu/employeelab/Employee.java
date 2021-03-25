package com.ncu.employeelab;
import org.springframework.stereotype.Component;

@Component("accountDao")
public class Employee {
	String Name;
	String Address;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		System.out.println("in set name");
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String accountNo) {
		Address = accountNo;
	}

	public void calculate_sal() {
		System.out.println("in calculate salary");
	}

	public Employee getemployee() {
		// TODO Auto-generated method stub
		return new Employee();
	}
	
}
