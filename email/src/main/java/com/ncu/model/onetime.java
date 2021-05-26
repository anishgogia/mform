package com.ncu.model;



public class onetime {
	 
		
		 private String one;

	public onetime() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "onetime [one=" + one + "]";
	}

	public onetime( String one) {
		super();
		this.one = one;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}
}
