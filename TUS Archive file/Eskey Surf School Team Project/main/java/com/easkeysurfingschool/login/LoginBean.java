package com.easkeysurfingschool.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.easkeysurfschool.reset.Customer;


/*
 * This example shows how to login for a single user with fixed username and password
 */

@ManagedBean
@SessionScoped
public class LoginBean {
	
	
	
	String userName, password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validateUserLogin() {
		return validateUserLogin(true);
	}
	
	public String validateUserLogin(boolean addMessage) {
		String welcomePage = "/welcome.xhtml";
		for(Customer user : RegistrationBean.users) {
			if(userName.equals(user.getUserName())){
				if(userName.equals(user.getUserName()) && (password.equals(user.getPassword()))){
					return welcomePage;
				}
	
				else {
					if(addMessage)
					{
						FacesContext context=FacesContext.getCurrentInstance();
						FacesMessage errorMessage = new FacesMessage ("Invalid Username/Password Combination");
						errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
						context.addMessage(null,  errorMessage);	
					}
					return null;
				}			
			}
		}
		return null;
	}
}

//System.out.println("Please help");
//if (userName.equalsIgnoreCase("user2") && password.equals("password2")) {
//    return welcomePage;
//    

