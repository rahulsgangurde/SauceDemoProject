package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sauce_Demo.Sauce_Demo.Abstract_Componant;

public class LoginPage extends Abstract_Componant {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userEmail;

	@FindBy(id="password")
	WebElement Password;
	

	@FindBy(id="login-button")
	WebElement LoginButton;
	
	
	public void Visit() {
		driver.get("https://www.saucedemo.com/v1/index.html");
	}
	public Product_Catalogue LoginApplication(String email,String pass) {
		userEmail.sendKeys(email);
		Password.sendKeys(pass);
		LoginButton.click();
		Product_Catalogue pc = new Product_Catalogue(driver);
		return pc;
	}
	
	
}
