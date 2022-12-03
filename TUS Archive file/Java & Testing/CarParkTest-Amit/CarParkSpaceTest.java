package com.ait.carpark;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarParkSpaceTest {

	private CarParkSpace carParkSpace;
	private static final boolean NORMAL = false;

	@BeforeEach
	public void setUp() {
		carParkSpace = new CarParkSpace(NORMAL,1);
	}

	@Test
	void testCarParkSpaceConstructed() {
		assertFalse(carParkSpace.isPriorityParking());
		assertFalse(carParkSpace.isOccupied());
		assertEquals(null, carParkSpace.getRegistration());
		assertEquals(1, carParkSpace.getCarParkSpaceIdentifier());
	}

	@Test
	public void testChangePriorityParking() {
		carParkSpace.setPriorityParking(true);
		assertTrue(carParkSpace.isPriorityParking());
	}

	@Test
	public void testChangeOccupied() {
		carParkSpace.setOccupied(true);
		assertTrue(carParkSpace.isOccupied());
	}

	@Test
	public void testChangeRegistration() {
		carParkSpace.setRegistration("201G1234");
		assertEquals("201G1234", carParkSpace.getRegistration());
	}
	
	@Test
	public void testChangeCarParkSpaceIdentifier() {
		carParkSpace.setCarParkSpaceIdentifier(2);
		assertEquals(2, carParkSpace.getCarParkSpaceIdentifier());
	}

}
