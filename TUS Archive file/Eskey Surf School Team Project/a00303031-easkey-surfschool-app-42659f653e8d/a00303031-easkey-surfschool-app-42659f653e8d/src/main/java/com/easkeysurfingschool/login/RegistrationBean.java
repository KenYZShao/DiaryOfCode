package com.easkeysurfingschool.login;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped

public class RegistrationBean implements Serializable {
    private static final long serialVersionUID = 1L;

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

    // Validate Email
    public String validateRegistration() throws ValidatorException {
        if (email.indexOf("@") == -1) {
            FacesMessage message = new FacesMessage("Email Address is InValid");
            throw new ValidatorException(message);
        }
        else if(!password.equals(confirmPassword))
        {
            FacesMessage message = new FacesMessage("password does not match confirm password");
            throw new ValidatorException(message);
        }
        else
        {
            FacesMessage message = new FacesMessage("Account set-up sussessful!");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "welcome.xhtml";
        }
    }

     // Action Methods
    public String storeInfo() {
        boolean stored = true;
        FacesMessage message = null;
        String outcome = null;
        if (stored) {
         //   message = new FacesMessage("Account set-up sussessful!");
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