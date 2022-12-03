package com.easkeysurfschool.reset;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ResetPassword implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String validateResetPassword() {
		ArrayList<Customer> customerList = new ArrayList<>();
		//get username and password from File/DB and update in the customerList 
		Customer customer1 = new Customer("user1", "password1");
		customerList.add(customer1);
		Customer customer2 = new Customer("user2", "password2");
		customerList.add(customer2);
		Customer customer3 = new Customer("user3", "password3");
		customerList.add(customer3);
		Customer staff1 = new Customer("staff", "admin");
		customerList.add(staff1);
		
		FacesContext context = FacesContext.getCurrentInstance();
		for (Customer customer : customerList) {
			System.out.println("Customer " +customer);
			if (userName.equalsIgnoreCase(customer.getUserName()) && oldPassword.equals(customer.getPassword())) {
				if (!newPassword.equals(confirmPassword)) {
					System.out.println("New Password and Confirm New Password should be same");
					FacesMessage errorMessage = new FacesMessage("New Password and Confirm New Password should be same.");
					errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
					context.addMessage(null, errorMessage);
					return (null);
				}
				//update old_password in File/DB with new_password
				return "ResetPasswordSuccess.xhtml";
			}
		}
		System.out.println("Failed to validate password");
		FacesMessage errorMessage = new FacesMessage("Invalid Username/Old Password Combination.");
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, errorMessage);
		return (null);
	}
}
