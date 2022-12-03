package com.easkeysurfschool.reset;

public class Customer {
	private String userName;
	private String password;
	private String email;

	public Customer(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;

	}

	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		this.email = email;
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public String setUserName(String userName) {
		this.userName = userName;
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		this.password = password;
		return password;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}



}
