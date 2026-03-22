package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	@Test( description = "Validate if user is able to logout")
	public void verifyUserAbleToLogout() throws IOException {
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		System.out.println("Entering username" +username);
		loginpage.enterPassword(password);
		System.out.println("Entering password" +password);

		loginpage.clickSigninButton();
	
		HomePage hompage = new HomePage(driver);
		System.out.println("Enter Hompage");

		hompage.clickAdminDropdown();
	
		hompage.clickLogout();
		
		String pagetitle= loginpage.getTextFromTitle();
		String expectedpagetitle = "7rmart supermarket";
		Assert.assertEquals(pagetitle, expectedpagetitle, "Logout is not success");
	}

}
