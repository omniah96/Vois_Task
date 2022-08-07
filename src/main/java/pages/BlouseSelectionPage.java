package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BlouseSelectionPage {
	
	WebDriver driver;
	
	public BlouseSelectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By selectedBlouse = By.xpath("//img[@title=\"Blouse\"]");
	
	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?id_category=7&controller=category");
	}
	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void chooseBlouse() {
		driver.findElement(selectedBlouse).click();
	}

}
