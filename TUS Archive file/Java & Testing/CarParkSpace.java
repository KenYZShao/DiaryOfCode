package tus.test.car;

public class CarParkSpace {

	private int carParkSpaceIdentifier;
	private boolean occupied;
	private String registration;
	private boolean PriorityParking;
	
	public CarParkSpace(int iden, boolean prio) {
		this.PriorityParking = prio;
		this.occupied = false;
		this.registration = null;
		this.carParkSpaceIdentifier = iden;
	}

	public int getCarParkSpaceIdentifier() {
		return carParkSpaceIdentifier;
	}

	public void setCarParkSpaceIdentifier(int carParkSpaceIdentifier) {
		this.carParkSpaceIdentifier = carParkSpaceIdentifier;
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

	public boolean isPriorityParking() {
		return PriorityParking;
	}

	public void setPriorityParking(boolean priorityParking) {
		PriorityParking = priorityParking;
	}
	
}
