package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	WebDriver driver;
	WebDriverWait wait;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?id_product=2&controller=product");
	}

	By addToCartButton = By.xpath("//p[@id=\"add_to_cart\"]//button[@type=\"submit\"]");

	public void scrollWithJs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickAddToCart() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
		driver.findElement(addToCartButton).click();
	}
}
