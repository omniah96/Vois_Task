package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OrderPaymentConfirmation {
	WebDriver driver;

	public OrderPaymentConfirmation(WebDriver driver) {
		this.driver = driver;
	}

	By iConfirmMyOrferButton = By.xpath("//p[@class=\"cart_navigation clearfix\"]//button[@class=\"button btn btn-default button-medium\"]");

	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment");
	}

	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickIConfirmMyOrferButton() {
		driver.findElement(iConfirmMyOrferButton).click();
	}
}
