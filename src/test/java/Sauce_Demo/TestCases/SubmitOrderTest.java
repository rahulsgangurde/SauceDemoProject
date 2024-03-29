package Sauce_Demo.TestCases;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LoginPage;
import PageObjects.Product_Catalogue;
import PageObjects.confirmationPage;
import TestComponent.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	//String productName = "Sauce Labs Bike Light";
	
	@Test(dataProvider = "getData")
	public void submitOrder(String email,String password,String productName) throws IOException {
		
		

	//	LoginPage loginPage = launchApplication();

		Product_Catalogue pc = loginPage.LoginApplication(email, password);

		List<WebElement> products = pc.GetProductList();
		pc.addProducttoCart(productName);
		pc.GotoCartPage();

		CartPage cartpage = new CartPage(driver);
		Boolean Match = cartpage.VerifyProductdisplay(productName);

		assertTrue(Match);
		CheckoutPage checkoutPage = cartpage.Checkout();

		// CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.CheckoutInformation("NEW", "USER", "123456");
		confirmationPage confirmationPage = checkoutPage.ContinueProcess();

		// confirmationPage confirmationPage = new confirmationPage(driver);
		confirmationPage.finish();
		String ConfirmMessage = confirmationPage.getConfirmationMessage();

		assertTrue(ConfirmMessage.equalsIgnoreCase("THANK YOU FOR YOUR ORDER"));
		
	}
	
	
	
	@DataProvider
	public  Object[][] getData() {
		
		return new Object [][] {{"standard_user","secret_sauce","Sauce Labs Bike Light"},{"performance_glitch_user","secret_sauce","Sauce Labs Bike Light"}};
	}
	
}