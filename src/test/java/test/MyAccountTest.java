package test;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.AddToCartPage;
import pages.AdressConfirmationPage;
import pages.AuthenticationgMyUserPage;
import pages.CartConfirmationPage;
import pages.BlouseSelectionPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.OrderHistoryPage;
import pages.OrderPaymentConfirmation;
import pages.PaymentPage;
import pages.RegisterationPage;
import pages.ShippingConfirmationPage;
import pages.SignInPage;
//import pages.SubCategoryPage;
import pages.SummaryPage;
import pages.WomenCategoryPage;

public class MyAccountTest extends BaseTest {
	SignInPage signInObject;
	RegisterationPage registerationObject;
	LoginPage loginObject;
	AuthenticationgMyUserPage authObject;
	WomenCategoryPage womenObject;
	BlouseSelectionPage dObject;
	AddToCartPage addToCartObject;
	CartConfirmationPage cartConfirmationObject;
	SummaryPage summaryObject;
	AdressConfirmationPage addconfObject;
	ShippingConfirmationPage shippingObject;
	PaymentPage paymentObject;
	OrderPaymentConfirmation orderPaymentConfirmObject;
	OrderConfirmationPage orderCofirmationObject;
	OrderHistoryPage orderHistoryPageObject;

	/* testing SignIn process */
	@Test(priority = 1)
	public void testSignIn() {
		signInObject = new SignInPage(driver);
		signInObject.navigate();
		signInObject.clickSignInButton();
	}

	/* testing the registration process */
	
	@Test(dependsOnMethods = "testSignIn")
	public void testRegisterationPage() {
		registerationObject = new RegisterationPage(driver);
		registerationObject.navigate();
		registerationObject.registerUser("Omnwd4@gmail.com");
		registerationObject.clickCreateAccountButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/* testing the login process using data added to JSON file*/
	
	@Test(dependsOnMethods = "testRegisterationPage")
	public void testLoginPage() throws IOException, ParseException {
		loginObject = new LoginPage(driver);
		
		loginObject.navigate();
		
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		
		loginObject.createAccount(jsonReader.firstName, jsonReader.lastName, jsonReader.password,
				jsonReader.companyName, jsonReader.companyAddress, jsonReader.companyBuilding, jsonReader.city,jsonReader.postalCode,
				jsonReader.phoneNumber, jsonReader.alisaAddress);
	}
	
	/* testing that a new user is really created */
	
	@Test(dependsOnMethods = "testLoginPage")
	public void authenticatingMyUser() {
		authObject = new AuthenticationgMyUserPage(driver);

		String userName = authObject.authenticatingUser();
		Assert.assertEquals(userName, "Omnia Elshalawy");

	}
     
	/* testing choosing women category and blouse sub-category process */
	
	@Test(dependsOnMethods = "testLoginPage")
	public void testWomenCategory() {

		womenObject = new WomenCategoryPage(driver);
		womenObject.navigate();

		womenObject.hoverOverWomenCategoryChooseBlouseSubCategory();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/* testing choosing the blouse product */
	
	@Test(dependsOnMethods = "testWomenCategory")
	public void testBlouseSelection() {
		dObject = new BlouseSelectionPage(driver);
		dObject.navigate();

		dObject.scrollWithJs();
		dObject.chooseBlouse();
	}

	/* testing open product details page */
	
	@Test(dependsOnMethods = "testBlouseSelection")
	public void testopenProductDetail() {
		addToCartObject = new AddToCartPage(driver);
		addToCartObject.navigate();
		addToCartObject.scrollWithJs();
		addToCartObject.clickAddToCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	/* testing confirming choosing the blouse product */
	
	@Test(dependsOnMethods = "testopenProductDetail")
	public void testCartDetails() {
		cartConfirmationObject = new CartConfirmationPage(driver);
		//cartConfirmationObject.navigate();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		cartConfirmationObject.clickproceedToCheckButton();
	}

	/* testing confirming the order in the summary page */
	
	@Test(dependsOnMethods = "testCartDetails")
	public void testSummaryPage() {
		summaryObject = new SummaryPage(driver);
		summaryObject.navigate();
		summaryObject.scrollWithJs();

		summaryObject.clickProceedToCheckOutButton();
	}

	/* testing confirming the address*/
	
	@Test(dependsOnMethods = "testSummaryPage")
	public void testAdressConfirmationPage() {
		addconfObject = new AdressConfirmationPage(driver);
		addconfObject.navigate();

		addconfObject.scrollWithJs();
		addconfObject.clickAdressConfirmationButton();
	}

	/* testing confirming the shipping information */
	
	@Test(dependsOnMethods = "testAdressConfirmationPage")
	public void testShippingProcess() {
		shippingObject = new ShippingConfirmationPage(driver);
		//shippingObject.navigate();
		shippingObject.scrollWithJs();

		shippingObject.clickAgreementBox();
		shippingObject.clickProcessCarrierButton();
	}

	/* testing confirming the paymentMethod */
	
	@Test(dependsOnMethods = "testShippingProcess")
	public void testPaymentPage() {
		paymentObject = new PaymentPage(driver);
		//paymentObject.navigate();
		paymentObject.scrollWithJs();
		paymentObject.clickBankWireButton();
	}
	
	/* testing confirming the order*/

	@Test(dependsOnMethods = "testPaymentPage")
	public void testOrderConfirmation() {
		orderPaymentConfirmObject = new OrderPaymentConfirmation(driver);
		orderPaymentConfirmObject.navigate();
		orderPaymentConfirmObject.scrollWithJs();
		orderPaymentConfirmObject.clickIConfirmMyOrferButton();
	}

	/* testing validating the order*/
	
	@Test(dependsOnMethods = "testOrderConfirmation")
	public void testOrderConfirmationPage() {
		orderCofirmationObject = new OrderConfirmationPage(driver);
		orderCofirmationObject.scrollWithJs();
		orderCofirmationObject.orderValidation();
	}

	/* Asserting the order is added to the table of orders which means number of orders(rows in the table body) will be more than zero*/
	
	@Test(dependsOnMethods = "testOrderConfirmationPage")
	public void testorderHistoryPage() {
		orderHistoryPageObject = new OrderHistoryPage(driver);
		orderHistoryPageObject.navigate();
		int numberOfOrderss = orderHistoryPageObject.assertingOrderWasPlaced();
		System.out.println(numberOfOrderss);

		Assert.assertTrue(numberOfOrderss > 0);
	}

}
