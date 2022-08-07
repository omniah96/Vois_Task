package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	String url = "http://automationpractice.com/index.php";
	
	public void navigate() {
		driver.navigate().to(url);
	}
	
	By signInButton = By.className("login");
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}

}
