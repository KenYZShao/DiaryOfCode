package com.ait.carpark;

public class CarParkSpace {
	private boolean priorityParking;
	private boolean occupied;  //setOccupied, isOccupied
	private String registration;   //getRegistration, setRegistration
	private int carParkSpaceIdentifier;
	
	public CarParkSpace(boolean priorityParking,int carParkSpaceIdentifier) {
		this.priorityParking=priorityParking;
		this.occupied=false;
		this.registration=null;
		this.carParkSpaceIdentifier=carParkSpaceIdentifier;
	}
	public boolean isPriorityParking() {
		return priorityParking;
	}
	public void setPriorityParking(boolean priorityParking) {
		this.priorityParking = priorityParking;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public int getCarParkSpaceIdentifier() {
		return carParkSpaceIdentifier;
	}
	public void setCarParkSpaceIdentifier(int carParkSpaceIdentifier) {
		this.carParkSpaceIdentifier = carParkSpaceIdentifier;
	}

}
