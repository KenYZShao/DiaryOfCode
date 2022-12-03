package tus.test.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarParkTest {
	CarPark park;
	CarParkSpace v1;
	CarParkSpace n1;
	
	@BeforeEach
	void setUp() {
		park = new CarPark();
		n1 = new CarParkSpace(1, false);
		v1 = new CarParkSpace(2, true);
	}
	
	
	@Test
	void testNoVipSpacesAvailable() {
		assertEquals(park.getNumberOfVipSpaces(),0);
	}
	
	@Test
	void testNoNormalSpacesAvailable() {
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
	}
	
	@Test
	void testOneVipAndOneNormal() {
		park.addParkingSpace(v1);
		park.addParkingSpace(n1);
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
		assertEquals(park.getNumberOfVipSpaces(),1);
	}
	
	@Test
	void testBookVIPSpaceOK() {
		park.addParkingSpace(v1);
		park.addParkingSpace(n1);
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
		assertEquals(park.getNumberOfVipSpaces(),1);
		assertEquals("OK",park.bookVipPlace("Test"));
		assertEquals(park.getNumberOfVipSpaces(),0);
		
	}
	
	@Test
	void testBookNormalSpaceOK() {
		park.addParkingSpace(v1);
		park.addParkingSpace(n1);
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
		assertEquals(park.getNumberOfVipSpaces(),1);
		assertEquals("OK",park.bookNormalSplace("Test"));
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
	}
	
	@Test
	void testBookVIPSpaceNotAvailable() {
		park.addParkingSpace(n1);
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
		assertEquals(park.getNumberOfVipSpaces(),0);
		assertEquals("NO",park.bookVipPlace("Test"));
	}
	
	@Test
	void testBookNormalSpaceNotAvailable() {
		park.addParkingSpace(v1);
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
		assertEquals(park.getNumberOfVipSpaces(),1);
		assertEquals("NO",park.bookNormalSplace("Test"));
	}
	
	@Test
	void testReleaseParkingSpace() {
		park.addParkingSpace(n1);
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
		assertEquals("OK",park.bookNormalSplace("Test"));
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
		park.vacateParkingSpace("Test");
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
	}
	
	@Test
	void testReleaseParkingSpaceInvalidReg() {
		park.addParkingSpace(n1);
		assertEquals(park.getNumberOfNormalSpacesFree(),1);
		assertEquals("OK",park.bookNormalSplace("Test"));
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
		park.vacateParkingSpace("Test1");
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
	}
	@Test
	void testFindVehicleOK() {
		park.addParkingSpace(n1);
		assertEquals("OK",park.bookNormalSplace("Test"));
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
		assertEquals(park.findMyVehicle("Test"),n1.getCarParkSpaceIdentifier());
	}
	@Test
	void testFindVehicleNotFound() {
		park.addParkingSpace(n1);
		assertEquals("OK",park.bookNormalSplace("Test"));
		assertEquals(park.getNumberOfNormalSpacesFree(),0);
		assertEquals(park.findMyVehicle("Test1"),0);
	}
}
