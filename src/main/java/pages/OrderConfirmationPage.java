package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	By backToOrdersButton = By.xpath("//p[@class=\"cart_navigation exclusive\"]//a[@title=\"Back to orders\"]");
	
	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void orderValidation() {
		driver.findElement(backToOrdersButton).click();
	}

}
