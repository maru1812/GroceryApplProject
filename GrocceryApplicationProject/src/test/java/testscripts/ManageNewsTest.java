package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test ( description = "Validate if admin able to add new news")
	public void verifyUserIsAbleTOAddNewNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSigninButton();
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoIcon();
		String newsheadline = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnAddNewsButton();
		news.enterNews(newsheadline);
		news.clickOnSaveNewsButton();
		String actualalert = news.successalertmsg();
		System.out.println(actualalert);
		int startpos = actualalert.indexOf("News");
		System.out.println(startpos);
		
		  String message = actualalert.substring(startpos).trim();
		  
		  System.out.println(message);
		  
		  Assert.assertEquals("News Created Successfully", message,
		  "News creation is not success");
		 

	}

	@Test( description = "Validate if admin able to search news")
	public void verifyUserIsAbleTOSearchNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSigninButton();
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoIcon();
		String newsheading = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnSearchButton();
		news.searchforNews(newsheading);
		news.performSearch();
		Boolean f = news.findtable();
		System.out.println(f);
		Assert.assertTrue(f, "After Search table is not shown");
		
	}

	@Test( description = "Validate if admin able to reset news section")
	public void verifyUserIsAbleToResetNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSigninButton();
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoIcon();
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnResetButton();
		Boolean f = news.findtable();
		System.out.println(f);
		Assert.assertTrue(f, "After Reset table is not shown");
	}}
