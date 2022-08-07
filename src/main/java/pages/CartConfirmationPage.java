package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartConfirmationPage {

	WebDriver driver;
	
	public CartConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By proceedToCheckButton = By.xpath("//a[@title=\"Proceed to checkout\"]");
	//By proceedToCheckButton = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");
	public void clickproceedToCheckButton() {
		driver.findElement(proceedToCheckButton).click();
	}
}
