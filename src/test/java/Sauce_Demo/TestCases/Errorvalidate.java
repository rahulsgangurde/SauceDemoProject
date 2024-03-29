package Sauce_Demo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Product_Catalogue;
import TestComponent.BaseTest;

public class Errorvalidate extends BaseTest{
	@Test
	public void Errorvalidate() {
		
		String productName = "Sauce Labs Bike Light";
		loginPage.LoginApplication("standard_user", "secret");
		Product_Catalogue product_Catalogue= new Product_Catalogue(driver);
		product_Catalogue.verifyproductLabel();
	
		
		
		
		
}
}