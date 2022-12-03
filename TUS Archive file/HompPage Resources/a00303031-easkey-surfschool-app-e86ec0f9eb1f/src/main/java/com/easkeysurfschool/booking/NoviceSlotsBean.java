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
public class NoviceSlotsBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final static String NOVICE_SLOT = "Novice";
	private String noviceSlot;
	private String userName;
	private Date noviceSlotDate;
	private boolean student;
	private String slotType; 
	
	public String getNoviceSlot() {
		return noviceSlot;
	}

	public void setNoviceSlot(String noviceSlot) {
		this.noviceSlot = noviceSlot;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getNoviceSlotDate() {
		return noviceSlotDate;
	}

	public void setNoviceSlotDate(Date noviceSlotDate) {
		this.noviceSlotDate = noviceSlotDate;
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

	public String validateNoviceSlots() {
		System.out.println("loginBean getUserName -> " +LoginBean.loggedInUser);
		setUserName(LoginBean.loggedInUser);
		setSlotType(NOVICE_SLOT);
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("IN validateNoviceSlots method");
		if (userName != null) {
			if (noviceSlot == null) {
				System.out.println("Please select the time slot");
				FacesMessage errorMessage = new FacesMessage("Please select the time slot");
				errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, errorMessage);
				return "null";
			}
			storeBookingDetails(userName, noviceSlot, noviceSlotDate, NOVICE_SLOT, student);
			System.out.println("Booking details stored " +BookedSlotDetails.getBookedSlotDetails());
			return "noviceBookingDetails.xhtml";
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
