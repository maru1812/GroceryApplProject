package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static int EXPLICITWAITTIME =5;
	public void waitUntilElementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITTIME));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementisVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITTIME));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitUntilElementisNotVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITTIME));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public void waitUntilStaleElementNotVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITTIME));
		wait.until(ExpectedConditions.stalenessOf(element));

	}
	
	public void waitUntilElementtobeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITTIME));
		wait.until(ExpectedConditions.elementToBeSelected(element));

	}
	
	public void waitUntilTextPresentInElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITTIME));
		wait.until(ExpectedConditions.textToBePresentInElement(element, "SAMPLE DATA HERE"));

	}
}
//all explicit wait - element to be clickable
//min of 5 method declare

