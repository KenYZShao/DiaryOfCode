package com.ait.carpark;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarParkTest {

	private CarPark myCarPark;
	private static final boolean NORMAL = false;
	private static final boolean VIP = true;
	
	@BeforeEach
    public void setUp() {
		myCarPark=new CarPark();
    }

	// User Story 1
	@Test // Test 1-1
	public void testNoVIPSpacesAvailable() {
		assertEquals(0, myCarPark.getNumberOfVIPSpacesFree());
	}
	
	@Test // Test 1-2
	public void testNoNormalSpacesAvailable() {
		assertEquals(0, myCarPark.getNumberOfNormalSpacesFree());
	}
	
	// User Story 2
	@Test // Test 2-1
	public void testOneVIPSpaceAndOneNormalAvailable() {
		CarParkSpace carParkSpaceVIP=new CarParkSpace(VIP,1);
		CarParkSpace carParkSpaceNormal=new CarParkSpace(NORMAL,2);
		myCarPark.addParkingSpace(carParkSpaceVIP);
		myCarPark.addParkingSpace(carParkSpaceNormal);
		assertEquals(1, myCarPark.getNumberOfVIPSpacesFree());
		assertEquals(1, myCarPark.getNumberOfNormalSpacesFree());
	}
	
	// User Story 3
		@Test // Test 3-1
		public void testBookVIPSpaceOK() {
			CarParkSpace carParkSpaceVIP=new CarParkSpace(VIP,1);
			CarParkSpace carParkSpaceNormal=new CarParkSpace(NORMAL,2);
			myCarPark.addParkingSpace(carParkSpaceVIP);
			myCarPark.addParkingSpace(carParkSpaceNormal);
			assertEquals("OK", myCarPark.bookVIPSpace("201D1234"));
			assertEquals(0, myCarPark.getNumberOfVIPSpacesFree());
		}
		@Test // Test 3-2
		public void testBookNormalSpaceOK() {
			CarParkSpace carParkSpaceVIP=new CarParkSpace(VIP,1);
			CarParkSpace carParkSpaceNormal=new CarParkSpace(NORMAL,2);
			myCarPark.addParkingSpace(carParkSpaceVIP);
			myCarPark.addParkingSpace(carParkSpaceNormal);
			assertEquals("OK", myCarPark.bookNormalSpace("201D1234"));
			assertEquals(0, myCarPark.getNumberOfNormalSpacesFree());
		}
		
		@Test // Test 3-3
		public void testBookNormalSpaceNotAvailable() {
			CarParkSpace carParkSpaceVIP=new CarParkSpace(VIP,1);
			CarParkSpace carParkSpaceNormal=new CarParkSpace(NORMAL,2);
			myCarPark.addParkingSpace(carParkSpaceVIP);
			myCarPark.addParkingSpace(carParkSpaceNormal);
			assertEquals("OK", myCarPark.bookNormalSpace("201D1234"));
			assertEquals("NOT AVAILABLE", myCarPark.bookNormalSpace("201D1236"));
		}
		
		@Test // Test 3-4
		public void testBookVIPSpaceNotAvailable() {
			CarParkSpace carParkSpaceVIP=new CarParkSpace(VIP,1);
			CarParkSpace carParkSpaceNormal=new CarParkSpace(NORMAL,2);
			myCarPark.addParkingSpace(carParkSpaceVIP);
			myCarPark.addParkingSpace(carParkSpaceNormal);
			assertEquals("OK", myCarPark.bookVIPSpace("201D1234"));
			assertEquals("NOT AVAILABLE", myCarPark.bookVIPSpace("201D1236"));
		}
}
