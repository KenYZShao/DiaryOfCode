package tus.test.car;

import java.util.ArrayList;

public class CarPark {

	private ArrayList<CarParkSpace> spaces;
	
	public CarPark() {
		spaces = new ArrayList<CarParkSpace>();
	}
	
	public int getNumberOfVipSpaces() {
		int space = 0;
		for(CarParkSpace car:spaces) {
			if(car.isPriorityParking()==true && car.isOccupied()==false) {
				space++;
			}
		}
		return space;
	}
	
	public int getNumberOfNormalSpacesFree() {
		int space = 0;
		for(CarParkSpace car:spaces) {
			if(car.isPriorityParking()==false && car.isOccupied()==false) {
				space++;
			}
		}
		return space;
	}
	public void addParkingSpace(CarParkSpace car) {
		spaces.add(car);
	}
	public String bookVipPlace(String reg) {
		for(CarParkSpace car:spaces) {
			if(car.isOccupied()==false && car.isPriorityParking() == true) {
				car.setRegistration(reg);
				car.setOccupied(true);
				return "OK";
				
			}
		}
		return "NO";
	}
	
	public String bookNormalSplace(String reg) {
		for(CarParkSpace car:spaces) {
			if(car.isOccupied()==false && car.isPriorityParking() == false) {
				car.setRegistration(reg);
				car.setOccupied(true);
				return "OK";
			}
		}
		return "NO";
	}
	public void vacateParkingSpace(String reg) {
		for(CarParkSpace car:spaces) {
			if(car.getRegistration().equals(reg)) {
				car.setRegistration(null);
				car.setOccupied(false);
				car.setPriorityParking(false);
			}
		}
	}
	public int findMyVehicle(String reg) {
		for(CarParkSpace car:spaces) {
			if(car.getRegistration().equals(reg)) {
				return car.getCarParkSpaceIdentifier();
			}
		}
		return 0;
	}
	
}
