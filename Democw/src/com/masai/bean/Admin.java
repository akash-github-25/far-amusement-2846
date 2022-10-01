package com.masai.bean;

public class Admin {
	
	private String Username;
	private String Password;
	

	@Override
	public String toString() {
		return "Admin [Username=" + Username + ", Password=" + Password + "]";
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public Admin() {
		super();
	}


	public Admin(String username, String password) {
		super();
		Username = username;
		Password = password;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
