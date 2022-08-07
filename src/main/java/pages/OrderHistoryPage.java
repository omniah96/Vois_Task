package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By myOrdersLink = By.xpath("//a[@title=\"My orders\"]");
	
	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=history");
	}
	
	public int assertingOrderWasPlaced() {
		
		WebElement webTable = driver.findElement(By.xpath("//table[@id=\"order-list\"]"));
		List <WebElement> rows =webTable.findElements(By.xpath("//tbody//tr"));
		System.out.println(rows);

		int numberOfOrders = rows.size();
		for (WebElement order: rows) {
			System.out.println(order.getText());
		}
		
		return numberOfOrders;

		
	}
	
}
