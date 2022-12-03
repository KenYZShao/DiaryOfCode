package com.ait.carpark;

import java.util.ArrayList;

public class CarPark {
	private ArrayList<CarParkSpace> carPark;

	public CarPark() {
		carPark = new ArrayList<CarParkSpace>();
	}
	
	
	public int getNumberOfVIPSpacesFree() {
		int numVIPSpaces = 0;
		for (CarParkSpace carParkSpace : carPark) {
			if (carParkSpace.isPriorityParking()) {
				if (carParkSpace.isOccupied() == false) {
					numVIPSpaces++;
				}
			}
		}
		return numVIPSpaces;
	}

	public int getNumberOfNormalSpacesFree() {
		int numNormalSpaces = 0;
		for (CarParkSpace carParkSpace : carPark) {
			if (carParkSpace.isPriorityParking() == false) {
				if (carParkSpace.isOccupied() == false) {
					numNormalSpaces++;
				}
			}
		}
		return numNormalSpaces;
	}

	public void addParkingSpace(CarParkSpace carParkSpace) {
		carPark.add(carParkSpace);
	}

	public String bookVIPSpace(String registration) {
		String result = "NOT AVAILABLE";
		for (CarParkSpace carParkSpace : carPark) {
			if (carParkSpace.isPriorityParking()) {
				if (carParkSpace.isOccupied() == false) {
					carParkSpace.setRegistration(registration);
					carParkSpace.setOccupied(true);
					result = "OK";
					break;
				}
			}
		}
		return result;
	}

	public String bookNormalSpace(String registration) {
		String result = "NOT AVAILABLE";
		for (CarParkSpace carParkSpace : carPark) {
			if (carParkSpace.isPriorityParking() == false) {
				if (carParkSpace.isOccupied() == false) {
					carParkSpace.setRegistration(registration);
					carParkSpace.setOccupied(true);
					result = "OK";
					break;
				}
			}
		}
		return result;
	}

}
