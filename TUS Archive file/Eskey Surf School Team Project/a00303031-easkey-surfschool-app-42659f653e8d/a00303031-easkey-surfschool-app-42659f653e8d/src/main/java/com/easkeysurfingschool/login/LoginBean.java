package com.easkeysurfingschool.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


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
	    
		String welcomePage = "/welcome.xhtml";
		
	    if (userName.equalsIgnoreCase("user1") && password.equals("password1")) {
	        return welcomePage;
	        
	    }if (userName.equalsIgnoreCase("user2") && password.equals("password2")) {
	        return welcomePage;
	        
	    }if (userName.equalsIgnoreCase("user3") && password.equals("password3")) {
	        return welcomePage;
	        
	    }if (userName.equalsIgnoreCase("staff") && password.equals("admin")) {
	        return "staffPage.xhtml";
	        
	    }else {
	    	System.out.println("here");
	    	FacesContext context=FacesContext.getCurrentInstance();
				FacesMessage errorMessage=
						new FacesMessage ("Invalid Username/Password Combination");
				errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null,  errorMessage);
				return (null);
	    }
	}

}
