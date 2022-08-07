package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By titleField = By.xpath("//input[@id=\"id_gender2\"]");
	By firstNameField = By.xpath("//input[@id=\"customer_firstname\"]");
	By lastNameField = By.xpath("//input[@id=\"customer_lastname\"]");
	By passwordField = By.xpath("//input[@id=\"passwd\"]");
	By birthDayField = By.xpath("//select[@id=\"days\"]");
	By birthMonthField = By.xpath("//select[@id=\"months\"]");
	By birthYearField = By.xpath("//select[@id=\"years\"]");
	By newsletterBoxField = By.xpath("//div[@class=\"checkbox\"]//div[@id=\"uniform-newsletter\"]");
	By offersBoxField = By.xpath("//div[@class=\"checkbox\"]//div[@id=\"uniform-optin\"]");
	
	By companyNameField = By.xpath("//input[@id=\"company\"]");
	By companyAddressField = By.xpath("//input[@id=\"address1\"]");
	By companyBuildingField = By.xpath("//input[@id=\"address2\"]");
	
	By cityField = By.xpath("//input[@id=\"city\"]");
	By stateDropDownField = By.xpath("//select[@id=\"id_state\"]");
	By postalCodeField = By.xpath("//input[@id=\"postcode\"]");
	By countryDropDownField = By.xpath("//select[@id=\"id_country\"]");
	By phoneNumberField = By.xpath("//input[@id=\"phone_mobile\"]");
	By alisaAddressField = By.xpath("//input[@id=\"alias\"]");
	By registerAccountField = By.xpath("//button[@id=\"submitAccount\"]");
	
	public void navigate() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	public void createAccount(String firstName ,String lastName ,String password ,String companyName,String companyAddress ,String companyBuilding ,String city,String postalCode,String phoneNumber,String alisaAddress) {
		
		driver.findElement(titleField).click();
		
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(passwordField).sendKeys(password);
		
		
		Select selectOptions = new Select (driver.findElement(birthDayField));
		selectOptions.selectByValue("12");
		
		Select selectOptions2 = new Select (driver.findElement(birthMonthField));
		selectOptions2.selectByValue("9");
		
		Select selectOptions3 = new Select (driver.findElement(birthYearField));
		selectOptions3.selectByValue("1996");
		
		driver.findElement(newsletterBoxField).click();
		driver.findElement(offersBoxField).click();
		
		driver.findElement(companyNameField).sendKeys(companyName);
		driver.findElement(companyAddressField).sendKeys(companyAddress);
		driver.findElement(companyBuildingField).sendKeys(companyBuilding);
		driver.findElement(cityField).sendKeys(city);
		
		Select selectOptions4 = new Select (driver.findElement(stateDropDownField));
		selectOptions4.selectByVisibleText("California");
		
		driver.findElement(postalCodeField).sendKeys(postalCode);
		
		Select selectOptions5 = new Select (driver.findElement(countryDropDownField));
		selectOptions5.selectByVisibleText("United States");
		
		driver.findElement(phoneNumberField).sendKeys(phoneNumber);
		driver.findElement(alisaAddressField).sendKeys(alisaAddress);
		
		driver.findElement(registerAccountField).click();		
	}
	
	
	
	
	



}
