package com.easkeysurfschool.booking;

import java.util.Date;

public class BookedSlotDetails {
	private String userName;
	private String slotTime;
	private Date slotDate;
	private String slotType;
	private boolean isStudent;
	
	private static BookedSlotDetails bookedSlot;// = new BookedSlotDetails();
	
	private BookedSlotDetails() {
		
	}

	public static BookedSlotDetails getBookedSlotDetails() {
		System.out.println("IN getBookedSlotDetails() bookedSlot ==> " +bookedSlot);
		if (bookedSlot == null) {
			bookedSlot = new BookedSlotDetails();
		}
		return bookedSlot;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	public Date getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}
	public String getSlotType() {
		return slotType;
	}
	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}
	
	public boolean isStudent() {
		return isStudent;
	}
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	@Override
	public String toString() {
		return "BookedSlotDetails [userName=" + userName + ", slotTime=" + slotTime + ", slotDate=" + slotDate
				+ ", slotType=" + slotType + ", isStudent=" + isStudent + "]";
	}
	
}
