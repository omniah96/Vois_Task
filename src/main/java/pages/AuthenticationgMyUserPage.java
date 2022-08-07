package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationgMyUserPage {

	WebDriver driver;
	
	public AuthenticationgMyUserPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By myUserName = By.xpath("//a[@title=\"View my customer account\"]");
	
	public String authenticatingUser() {
		return driver.findElement(myUserName).getText();
	}
}
