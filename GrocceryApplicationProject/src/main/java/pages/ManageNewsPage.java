package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locating elements to add news
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement addbtn;
	@FindBy(id ="news") WebElement enternewsdata;
	@FindBy(xpath ="//button[text()= 'Save']") WebElement savebtn;
	
	
	//Locating elements to search news
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchbtn;
	@FindBy(xpath = "//input[@class='form-control' and @name ='un']") WebElement newstitle;
	@FindBy(xpath ="//button[@class='btn btn-danger btn-fix' and @name ='Search']") WebElement performsearch;
	
	
	//Locating elements to reset news
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetbtn;

	@FindBy(xpath="//tbody")
	WebElement tbody;
	
	@FindBy(xpath ="//div[contains(@class,'alert-success') and contains(.,'News Created Successfully')]")
	WebElement successalert;
	
	public void clickOnAddNewsButton() {
		addbtn.click();
	}
	public void enterNews(String newsheadline) {
		enternewsdata.sendKeys(newsheadline);
	}
	public void clickOnSaveNewsButton() {
		savebtn.click();
	}
	
	//methods to search news
	
	public void clickOnSearchButton() {
		searchbtn.click();
	}
	
	public void searchforNews(String newsheading) {
		newstitle.sendKeys(newsheading);
		
	}
	
	public void performSearch() {
		performsearch.click();
	}
	
	public void clickOnResetButton() {
		resetbtn.click();
	}
	
	public Boolean findtable() {
		return tbody.isDisplayed();
	}
	public String successalertmsg() {
		return successalert.getText().trim();
	}
}
