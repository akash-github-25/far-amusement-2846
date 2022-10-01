package com.masai.bean;

public class Employee {
	private int empid;
	private String ename;
	private String email;
	private String Password;
	private String leaverequest;
	

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", email=" + email + ", Password=" + Password
				+ ", leaverequest=" + leaverequest + "]";
	}


	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getLeaverequest() {
		return leaverequest;
	}


	public void setLeaverequest(String leaverequest) {
		this.leaverequest = leaverequest;
	}


	public Employee(int empid, String ename, String email, String password, String leaverequest) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.email = email;
		this.Password = password;
		this.leaverequest = leaverequest;
	}


	public Employee() {
		super();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
