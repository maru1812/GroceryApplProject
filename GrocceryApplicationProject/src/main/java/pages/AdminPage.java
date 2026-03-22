package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

	public WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//section[@class='content']/div/a[contains(text(),'New')]")
	WebElement newbtn;
	@FindBy(xpath = "//section[@class='content']/div/a[contains(text(),'Search')]")
	WebElement searchTopbtn;
	@FindBy(xpath = "//section[@class='content']/div/a[contains(text(),'Reset')]")
	WebElement resetbtn;

	@FindBy(id = "username")
	WebElement newuserusername;
	@FindBy(id = "password")
	WebElement newuserpassword;
	@FindBy(id = "user_type")
	WebElement userTypeDropDown;
	@FindBy(name = "Create")
	WebElement newsUsrSaveBtn;
	@FindBy(xpath = "//div[@class='card-footer center']/a[contains(text(),'Reset')]")
	WebElement resetNewBtn;

	@FindBy(xpath = "//div/label[text()='Username']/following-sibling::input[@type='text']")
	WebElement searchUsrTxtbox;
	@FindBy(id = "ut")
	WebElement searchUserType;
	@FindBy(name = "Search")
	WebElement srchBtn;
	@FindBy(xpath ="//div[contains(@class,'alert-success') and contains(.,'User Created Successfully')]")
	WebElement successalert;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement userinsearchtable;
	
	@FindBy(xpath="//tbody")
	WebElement tbody;

	public void clickaddNewUser() {
		newbtn.click();
	}

	public void clickSearchUser() {
		searchTopbtn.click();
	}

	public void clickReset() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(resetbtn));
		resetbtn.click();
	}

	public void enterNewUserName(String usr) {
		newuserusername.sendKeys(usr);
	}

	public void enterNewUserPassword(String pwd) {
		newuserpassword.sendKeys(pwd);
	}

	public void selectNewUserType(String usrtype) {
		Select select = new Select(userTypeDropDown);
		select.selectByVisibleText(usrtype);
	}

	public void clickSaveNewUser() {
		newsUsrSaveBtn.click();
	}

	public void enterSearchUsertxt(String searchusr) {
		searchUsrTxtbox.sendKeys(searchusr);
	}

	public void selectSearchUserType(String srchusrtyp) {
		Select select = new Select(searchUserType);
		select.selectByVisibleText(srchusrtyp);
	}

	public void clickSrchbtnForSearchUser() {
		srchBtn.click();
	}
	
	public String successalertmsg() {
		return successalert.getText().trim();
	}
	
	public String searchtable() {
		return userinsearchtable.getText();
	}
	
	public Boolean findtable() {
		return tbody.isDisplayed();
	}
}
