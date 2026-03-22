package testscripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends Base {

	/** Add New User TC **/

	@Test(description = "Validate if admin able to add new user")
	public void adminAddNewUser() throws IOException {
		FakerUtility fakerobj = new FakerUtility();

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");

		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		System.out.println("Entering username" + username);
		loginpage.enterPassword(password);
		System.out.println("Entering password" + password);
		loginpage.clickSigninButton();

		HomePage homepage = new HomePage(driver);
		homepage.clickadminUsersMoreInfo();
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickaddNewUser();
		/** Try adding For loop **/
		String newUsername = fakerobj.createRandomUserName();
		// String newUsername = ExcelUtility.readStringData(0, 0, "AdminPage");
		String newPassword = ExcelUtility.readStringData(0, 1, "AdminPage");
		String newUserType = ExcelUtility.readStringData(0, 2, "AdminPage");

		adminpage.enterNewUserName(newUsername);
		adminpage.enterNewUserPassword(newPassword);
		adminpage.selectNewUserType(newUserType);
		adminpage.clickSaveNewUser();
		String actualalert = adminpage.successalertmsg();
		int startpos = actualalert.indexOf("User Created");
		System.out.println(startpos);
		String message = actualalert.substring(startpos).trim();

		System.out.println(message);

		Assert.assertEquals("User Created Successfully", message, "User creation is not success");
	}

	/** Search User TC **/
	@Test(description = "Validate if admin able to search user")
	public void adminSearchUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();

		HomePage homepage = new HomePage(driver);

		homepage.clickadminUsersMoreInfo();
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickSearchUser();

		String srchUsername = ExcelUtility.readStringData(0, 0, "AdminPage");
		String srchUserType = ExcelUtility.readStringData(0, 2, "AdminPage");
		adminpage.enterSearchUsertxt(srchUsername);
		adminpage.selectSearchUserType(srchUserType);
		adminpage.clickSrchbtnForSearchUser();
		String actual = adminpage.searchtable();
		Assert.assertEquals(actual, srchUsername, "Searched user is not present");

	}

	/** Reset User TC **/
	@Test(description = "Validate if admin able to reset user added section")
	public void adminResetUsers() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		System.out.println("Entering username" + username);
		loginpage.enterPassword(password);
		System.out.println("Entering password" + password);
		loginpage.clickSigninButton();

		HomePage homepage = new HomePage(driver);

		homepage.clickadminUsersMoreInfo();
		AdminPage adminpage = new AdminPage(driver);

		adminpage.clickReset();
		Boolean f = adminpage.findtable();
		System.out.println(f);
		Assert.assertTrue(f, "After Reset table is not shown");
	}
}
