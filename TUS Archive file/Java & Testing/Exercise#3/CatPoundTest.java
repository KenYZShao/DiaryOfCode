package com.ait.catpound;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatPoundTest {
	private CatPound myCatPound;
	@BeforeEach
    public void setUp() {
		myCatPound=new CatPound();
    }
	
	//User Story 1
	@Test  //Test 1-1
	public void testNoCatsInPound() {
		assertEquals(0,myCatPound.getNumberOfCats());
	}
	
	// User Story 2
	@Test   //Test 2-2 (includes 2-1)
	public void testOneCatInPound() {
		assertEquals(0,myCatPound.getNumberOfCats());
		Cat firstCat=new Cat("James",2,"Black");
		myCatPound.addCat(firstCat);
		assertEquals(1,myCatPound.getNumberOfCats());
	}
	
	@Test  //Test 2-3
	public void testTwoCatInPound() {
		Cat firstCat=new Cat("James",2,"Black");
		Cat secondCat=new Cat("Trevor",1,"Brown");
		myCatPound.addCat(firstCat);
		myCatPound.addCat(secondCat);
		assertEquals(2,myCatPound.getNumberOfCats());
	}
	
	//User Story 3
	@Test  //Test 3-1
	public void testCatRemovedFromPound() {
		Cat firstCat=new Cat("James",2,"Black");
		Cat secondCat=new Cat("Trevor",1,"Brown");
		myCatPound.addCat(firstCat);
		myCatPound.addCat(secondCat);
		assertEquals(2,myCatPound.getNumberOfCats());
		myCatPound.removeCat(firstCat);
		assertEquals(1,myCatPound.getNumberOfCats());
	}
	//User Story 4
	@Test  //Test 4-1
	public void testForCatByName() {
		Cat firstCat=new Cat("James",2,"Black");
		//Cat secondCat=new Cat("Trevor",1,"Brown");
		myCatPound.addCat(firstCat);
		assertTrue(myCatPound.searchCatName("James"));
		assertFalse(myCatPound.searchCatName("Trevor"));
	}
		

	@Test  //Test 5-1
	public void testForNumCatsByOlderThan() {
		Cat firstCat=new Cat("James",2,"Black");
		Cat secondCat=new Cat("Trevor",5,"Brown");
		myCatPound.addCat(firstCat);
		myCatPound.addCat(secondCat);
		assertEquals(1,myCatPound.getNumberOlderThan(4));
		
	}

}
