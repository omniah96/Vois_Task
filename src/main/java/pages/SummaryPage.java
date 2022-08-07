package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SummaryPage {

	WebDriver driver;

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	By proceedToCheckOutButton = By.xpath("//p[@class=\"cart_navigation clearfix\"]//a[@title=\"Proceed to checkout\"]");

	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=order");
	}
	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickProceedToCheckOutButton() {
		driver.findElement(proceedToCheckOutButton).click();
	}

}
