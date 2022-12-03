package com.easkeysurfingschool.com.login;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.easkeysurfingschool.login.LoginBean;

class LoginTest {

	@Test
	void testValidUsers() {
		LoginBean mockLogin = new LoginBean();
		
		mockLogin.setPassword("password1");
		mockLogin.setUserName("user1");
		
		String result = mockLogin.validateUserLogin(false);
		assertEquals(result, "/welcome.xhtml");
	}
	
	@Test
	void testInValidUsers() {
		LoginBean mockLogin = new LoginBean();
		mockLogin.setPassword("badUser");
		mockLogin.setUserName("badPassword");
		
		String result = mockLogin.validateUserLogin(false);
		assertEquals(result, null);
	}

	@Test
	void testInStaffUsers() {
		LoginBean mockLogin = new LoginBean();
		mockLogin.setPassword("admin");
		mockLogin.setUserName("staff");
		
		String result = mockLogin.validateUserLogin(false);
		assertEquals(result, "staffPage.xhtml");
	}
}
