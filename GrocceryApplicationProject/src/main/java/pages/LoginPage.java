package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signin;
	
	@FindBy(id="remember")
	WebElement checkbox;
	
	@FindBy(xpath ="//div/p[text()='Dashboard']")
	WebElement dashboardtiletext;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement applicationtitle;
	
	@FindBy(xpath="//div[contains(@class,'alert') and contains(., 'Invalid Username')]")
	WebElement alertmsg;
	
	public void enterUsername(String usr) {
		username.sendKeys(usr);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void rememberMe() {
		checkbox.click();
	}
	public void clickSigninButton() {
		signin.click();
	}

	public boolean isDashboardDisplayed() {
		return dashboardtiletext.isDisplayed();
	}
	
	public String getTextFromTitle() {
		return applicationtitle.getText();
	}
	
	public String readAlert() {
		return alertmsg.getText().trim();
	}
}
