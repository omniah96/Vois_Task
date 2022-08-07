package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ShippingConfirmationPage {
	WebDriver driver;

	public ShippingConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	By agreementCheckBox = By.xpath("//span//input[@type=\"checkbox\"]");
	By processCarrierButton = By.xpath("//button[@name=\"processCarrier\"]");
	
	/*public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=order");
	}*/

	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickAgreementBox() {
		driver.findElement(agreementCheckBox).click();
	}

	public void clickProcessCarrierButton() {
		driver.findElement(processCarrierButton).click();
	}
}
