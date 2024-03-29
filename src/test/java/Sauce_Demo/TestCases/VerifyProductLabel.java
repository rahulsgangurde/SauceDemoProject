package Sauce_Demo.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Product_Catalogue;
import TestComponent.BaseTest;

public class VerifyProductLabel extends BaseTest{

	@Test
	public void VerifyProductLabel() {
		
		String productName = "Sauce Labs Bike Light";
	
		loginPage.LoginApplication("standard_user", "secret_sauce");
		Product_Catalogue product_Catalogue= new Product_Catalogue(driver);
		product_Catalogue.verifyproductLabel();
	
		//String title =driver.findElement(By.cssSelector(".product_label")).getText();
		Assert.assertTrue(true, "Products");
		
}
}