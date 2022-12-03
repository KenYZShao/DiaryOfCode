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
public class IntermediateSlotsBean implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private final static String INTERMEDIATE_SLOT = "Intermediate";
	 
	 private String intermediateSlot;
		private String userName;
		private Date intermediateSlotDate;
		private boolean student;
		private String slotType;
		public String getIntermediateSlot() {
			return intermediateSlot;
		}
		public void setIntermediateSlot(String intermediateSlot) {
			this.intermediateSlot = intermediateSlot;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Date getIntermediateSlotDate() {
			return intermediateSlotDate;
		}
		public void setIntermediateSlotDate(Date intermediateSlotDate) {
			this.intermediateSlotDate = intermediateSlotDate;
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
		public String validateIntermediateSlots() {
			System.out.println("loginBean getUserName -> " +LoginBean.loggedInUser);
			setUserName(LoginBean.loggedInUser);
			setSlotType(INTERMEDIATE_SLOT);
			FacesContext context = FacesContext.getCurrentInstance();
			System.out.println("IN validateIntermediateSlots method");
			if (userName != null) {
				if (intermediateSlot == null) {
					System.out.println("Please select the time slot");
					FacesMessage errorMessage = new FacesMessage("Please select the time slot");
					errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
					context.addMessage(null, errorMessage);
					return "null";
					
				}
				storeBookingDetails(userName, intermediateSlot, intermediateSlotDate, "Intermediate", student);
				System.out.println("Booking details stored " +BookedSlotDetails.getBookedSlotDetails());
				return "intermediateBookingDetails.xhtml";
				}
			else {
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
