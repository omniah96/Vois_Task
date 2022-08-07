package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterationPage {
	WebDriver driver;
	
	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailField = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");
	
	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	public void registerUser(String email) {
		driver.findElement(emailField).sendKeys(email);

	}
	
	public void clickCreateAccountButton() {
		driver.findElement(createAccountButton).click();
	}
	
	
	

}
