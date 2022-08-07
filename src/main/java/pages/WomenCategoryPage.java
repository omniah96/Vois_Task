package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenCategoryPage {
	
	WebDriver driver;
	
	public WomenCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	String url = "http://automationpractice.com/index.php?controller=my-account";
	
	public void navigate() {
		driver.navigate().to(url);
	}
	public void hoverOverWomenCategoryChooseBlouseSubCategory() {
		Actions action = new Actions(driver);
		WebElement womenCategory = driver.findElement(By.xpath("//li[1]//a[text()='Women']"));
		WebElement blouseSubCategory = driver.findElement(By.xpath("//a[@title=\"Blouses\"]"));
		//action.scrollToElement(womenCategory).scrollToElement(blouseSubCategory).click(blouseSubCategory);
		action.moveToElement(womenCategory).scrollToElement(blouseSubCategory).build().perform();
	}
}
