package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sauce_Demo.Sauce_Demo.Abstract_Componant;

public class CartPage extends Abstract_Componant {
 

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[normalize-space()='CHECKOUT']")
	WebElement CheckoutEle;
	
	@FindBy(className ="inventory_item_name")
	List<WebElement> CartProducts;
	
	public Boolean VerifyProductdisplay(String productName) {
		Boolean Match = CartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return Match; 
	}
	public CheckoutPage Checkout() {
		
		CheckoutEle.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}