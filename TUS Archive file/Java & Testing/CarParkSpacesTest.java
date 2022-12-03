package tus.test.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarParkSpacesTest {

	CarParkSpace test;
	
	@BeforeEach
	void setUp() {
		test = new CarParkSpace(10, false);
	}
	
	@Test
	void testChangePriorityParking() {
		test.setPriorityParking(true);
		assertTrue(test.isPriorityParking());
	}
	@Test
	void testChangeCarParkSpaceIdentifier() {
		test.setCarParkSpaceIdentifier(5);
		assertEquals(test.getCarParkSpaceIdentifier(),5);
	}
	@Test
	void testChangeIsOccupied() {
		test.setOccupied(true);
		assertEquals(test.isOccupied(), true);
	}
	@Test
	void testParkSpaceConstructed() {
		assertFalse(test.isPriorityParking());
		assertFalse(test.isOccupied());
		assertEquals(null,test.getRegistration());
		assertEquals(10,test.getCarParkSpaceIdentifier());
	}
	@Test
	void testChangeRegistration() {
		test.setRegistration("hehe");
		assertEquals("hehe",test.getRegistration());
	}
}
