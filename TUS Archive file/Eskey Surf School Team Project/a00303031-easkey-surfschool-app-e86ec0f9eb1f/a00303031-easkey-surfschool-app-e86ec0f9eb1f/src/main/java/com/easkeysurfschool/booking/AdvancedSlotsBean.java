package com.easkeysurfschool.booking;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.easkeysurfingschool.login.LoginBean;

@ManagedBean
@SessionScoped
public class AdvancedSlotsBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final static String ADVANCED_SLOT = "Advanced";
	private String advancedSlot;
	private String userName;
	private Date advancedSlotDate;
	private boolean student;
	private String slotType; 
	
	public String getAdvancedSlot() {
		return advancedSlot;
	}

	public void setAdvancedSlot(String advancedSlot) {
		this.advancedSlot = advancedSlot;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getAdvancedSlotDate() {
		return advancedSlotDate;
	}

	public void setAdvancedSlotDate(Date advancedSlotDate) {
		this.advancedSlotDate = advancedSlotDate;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public String validateAdvancedSlots() {
		System.out.println("loginBean getUserName -> " +LoginBean.loggedInUser);
		setUserName(LoginBean.loggedInUser);
		setSlotType(ADVANCED_SLOT);
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("IN validateAdvancedSlots method");
		if (userName != null) {
			if (advancedSlot == null) {
				System.out.println("Please select the time slot");
				FacesMessage errorMessage = new FacesMessage("Please select the time slot");
				errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, errorMessage);
				return "null";
			}
			storeBookingDetails(userName, advancedSlot, advancedSlotDate, ADVANCED_SLOT, student);
			System.out.println("Booking details stored " +BookedSlotDetails.getBookedSlotDetails());
			return "advancedBookingDetails.xhtml";
		}else {
			System.out.println("Please Login to book the slot");
			return "/login/login.xhtml";
		}
	}

	private void storeBookingDetails(String loggedInUser, String slotTime, Date slotDate, String slotType, boolean student) {
		BookedSlotDetails bookedSlot = BookedSlotDetails.getBookedSlotDetails();
		bookedSlot.setUserName(loggedInUser);
		bookedSlot.setSlotTime(slotTime);
		bookedSlot.setSlotDate(slotDate);
		bookedSlot.setSlotType(slotType);
		bookedSlot.setStudent(student);
	}
}
