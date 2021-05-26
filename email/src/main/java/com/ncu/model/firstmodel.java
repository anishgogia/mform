package com.ncu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




public class firstmodel {
	
	public firstmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public firstmodel(String fname, String lname, String pin, String age, String add, String gender,
			@NotNull(message = "is required") @Size(min = 2, message = "is required") String eid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pin = pin;
		this.age = age;
		this.add = add;
		this.gender = gender;
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "firstmodel [fname=" + fname + ", lname=" + lname + ", pin=" + pin + ", age=" + age + ", add=" + add
				+ ", gender=" + gender + ", eid=" + eid + "]";
	}
	private String fname;
	
    public firstmodel(String one) {
		super();
		this.one = one;
	}
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	
	private String one;
	private String lname;
	
	 private String pin;
	 private String age;
	 private String add; 
	 private String gender;
	 @NotNull(message="is required")
	@Size(min=2,message="is required")
	 private String eid;
	public String getEid() {
		return eid;
	}
	public String setEid(String eid) {
		return this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
