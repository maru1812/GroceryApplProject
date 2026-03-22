package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Validate if user is  able to login with valid credentials")
	public void verifyAdminLoginWithValidCreds() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		System.out.println(username);
		loginpage.enterPassword(password);
		System.out.println(password);

		loginpage.clickSigninButton();

		Boolean dasboardVerify = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dasboardVerify, "User unable to login with Valid credentials");
	}

	@Test(priority = 2, description = "Validate if user is not able to login with invalid password")
	public void verifyAdminLoginWithInvalidPassword() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		System.out.println(username);
		loginpage.enterPassword(password);
		System.out.println(password);
		loginpage.clickSigninButton();
		String actual = loginpage.getTextFromTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "User able to login with invalid password");
	}

	@Test(priority = 3,description = "Validate if user is not able to login with invalid username")
	public void verifyAdminLoginWithInvalidUsername() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		String alertmsg = loginpage.readAlert();
		/**
		 * text from alert comes as × Alert! Invalid Username/Password 
		 **/
		int startpos = alertmsg.indexOf("Invalid"); 
		System.out.println(startpos);
		String message = alertmsg.substring(startpos).trim();

		System.out.println(message);
		
		 Assert.assertEquals("Invalid Username/Password", message,"Alert message not"
		 		+ " displayed with invalid username login");
	}

	@Test(priority = 4,description = "Validate if user is not able to login with invalid credentials")
	public void verifyAdminLoginWithInvalidcreds() throws IOException {

		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		String alertmsg = loginpage.readAlert();
		/**
		 * text from alert comes as × Alert! Invalid Username/Password 
		 **/
		int startpos = alertmsg.indexOf("Invalid"); 
		System.out.println(startpos);
		String message = alertmsg.substring(startpos).trim();

		System.out.println(message);
		
		 Assert.assertEquals("Invalid Username/Password", message,"Alert message not"
		 		+ " displayed with invalid credentials");
	}
}
