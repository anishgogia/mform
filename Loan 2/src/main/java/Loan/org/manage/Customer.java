package Loan.org.manage;

import org.springframework.stereotype.Component;

@Component("cust")
public class Customer implements ICustomer {

	String fullName, email;

	int age, phone;

	long aadhar;

	String pan;

	double income;

	double assetValue;

	double liabilityValue;

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}

	public double getLiabilityValue() {
		return liabilityValue;
	}

	public void setLiabilityValue(double liabilityValue) {
		this.liabilityValue = liabilityValue;
	}

	public String getLoan(LoanReq loan) {
		String l = loan.getKind() + ": " + loan.getAmount() + "$";
		return l;
	}

	public String getAddress(Address add) {
		String address = add.getHno() + ", " + add.getCity() + ", " + add.getState();
		return address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

}
