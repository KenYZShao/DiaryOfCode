package com.ait.catpound;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CatTest {
	private Cat myCat;
	@BeforeEach
    public void setUp() {
		myCat=new Cat("James", 3, "Black");
    }
	@Test
	public void testCatConstructor() {
		assertEquals("James", myCat.getName());
		assertEquals(3, myCat.getAge());
		assertEquals("Black", myCat.getColor());
	}
	
	@Test
	public void testChangeCatName() {
		myCat.setName("Tom");
		assertEquals("Tom", myCat.getName());
	}
	
	@Test
	public void testChangeCatAge() {
		myCat.setAge(5);
		assertEquals(5, myCat.getAge());
	}
	
	@Test
	public void testChangeCatColor() {
		myCat.setColor("Brown");
		assertEquals("Brown", myCat.getColor());
	}

}
