package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AdressConfirmationPage {
	WebDriver driver;

	public AdressConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	By adressConfirmationButton = By.xpath("//button[@name=\"processAddress\"]");
	
	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=order&step=1");
	}

	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickAdressConfirmationButton() {
		driver.findElement(adressConfirmationButton).click();
	}

}
