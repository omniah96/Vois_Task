package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	/*public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=order&multi-shipping=");
	}*/

	By bankWireButton = By.xpath("//a[@class=\"bankwire\"]");

	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickBankWireButton() {
		driver.findElement(bankWireButton).click();
	}
}
