package com.easkeysurfingschool.login;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.easkeysurfschool.reset.Customer;
import com.easkeysurfschool.reset.ResetPassword;

@ManagedBean
@SessionScoped

public class RegistrationBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public static ArrayList<Customer> users = new ArrayList<>();

	String userName;
	String email;
	String password;
	String confirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "RegistrationBean [userName=" + userName + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}

	// Validate Email
	public String validateRegistration() throws ValidatorException {
		String userName = getUserName();

		if (isAlreadyThere(userName, users) != -1) {
			System.out.println("here in reg username taken");
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage errorMessage = new FacesMessage("User name is aleady in use");
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, errorMessage);

			return null;
		}
//    	{
//    		 FacesMessage message = new FacesMessage("User name already in use");
//             throw new ValidatorException(message);
//        }

		if (email.indexOf("@") == -1) {
			System.out.println("here in regno @ symbol ");
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage errorMessage = new FacesMessage("Email address invalid");
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, errorMessage);

			return null;
		} else if (!password.equals(confirmPassword)) {
			System.out.println("here in reg password mismatch");
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage errorMessage = new FacesMessage("Password and password confimation do not match");
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, errorMessage);

			return null;
		} else {
			FacesMessage message = new FacesMessage("Account set-up sussessful!");
			FacesContext.getCurrentInstance().addMessage(null, message);

			createCustomer(userName, email, password);

			return "/welcome.xhtml";
		}
	}

	public static void addUser(ArrayList<Customer> users) {
		RegistrationBean regis = new RegistrationBean();
		String email = regis.getEmail();
		int index = isAlreadyThere(email, users);
		if (index == -1) {

			String password = regis.getPassword();
			String name = regis.getUserName();

			Customer cust = new Customer(name, email, password);

			users.add(cust);

		}

	}

	public static void changePassword(ArrayList<Customer> users) {
		RegistrationBean regis = new RegistrationBean();
		String email = regis.getEmail();

		int index = isAlreadyThere(email, users);
		if (index != -1) {
			Customer cust = users.get(index);
			ResetPassword reset = new ResetPassword();
			String resetPass = reset.getNewPassword();
			cust.setPassword(resetPass);
			System.out.println("here");

		}
	}

	public static int isAlreadyThere(String userName, ArrayList<Customer> users) {
		int index = -1;

		for (int i = 0; i < users.size(); i++) {
			Customer cust = users.get(i);
			if (cust.getUserName().equalsIgnoreCase(userName)) {
				index = i;
				System.out.println(userName + " is there already");
				break;
			}
		}
		return index;
	}

	public String createCustomer(String userName, String email, String password) {
		int index = isAlreadyThere(userName, users);
		if (index == -1) {
			Customer cust = new Customer(userName, password, email);
			RegistrationBean.users.add(cust);
			System.out.println(cust);
			return null;
		} else {
			System.out.println("here in reg");
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage errorMessage = new FacesMessage("User name aleady in use");
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, errorMessage);

			return null;
		}
	}

	// Action Methods
	public String storeInfo() {
		boolean stored = true;
		FacesMessage message = null;
		String outcome = null;
		if (stored) {
			// message = new FacesMessage("Account set-up sussessful!");
			outcome = "success";
			return "welcome.xhtml";
		}

		else {
			message = new FacesMessage("Please try again");
			outcome = "error";
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		return outcome;
	}

}