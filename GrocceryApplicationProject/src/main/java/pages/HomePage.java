package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//li[@class='nav-item dropdown']/a[@class='nav-link']/img")
	WebElement adminDropdown;
	
	@FindBy(xpath="//li[@class='nav-item dropdown show']//div[contains(@class,'dropdown-menu')]//a[contains(@href,'logout')]")
	WebElement logoutbtn;
	
	@FindBy(xpath ="//p[text()='Admin Users']/parent::div/following-sibling::a[text()='More info ']")
	WebElement adminUsersMoreInfo;
	
	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement newsinfoicon;
	
	public void clickAdminDropdown() {
		System.out.println("Click AdminDropdown");
		adminDropdown.click();
	}
		
	public void clickLogout() {
		System.out.println("Click LOGOUT");
		logoutbtn.click();
	}
	
	public void clickadminUsersMoreInfo() {
		adminUsersMoreInfo.click();
	}
	
	public void clickOnManageNewsMoreInfoIcon() {
		newsinfoicon.click();
}
}
