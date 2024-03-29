package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sauce_Demo.Sauce_Demo.Abstract_Componant;

public class CheckoutPage extends Abstract_Componant {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstName;

	@FindBy(xpath="//input[@id='last-name']")
	WebElement lasttName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement PostalCode;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement continueProcess;
	
	
	public void CheckoutInformation(String fName,String lName, String PCode) {
		
		firstName.sendKeys(fName);
		lasttName.sendKeys(lName);
		PostalCode.sendKeys(PCode);
	}
	public confirmationPage ContinueProcess() {
		
		continueProcess.click();
		confirmationPage confirmationPage = new confirmationPage(driver);
		return confirmationPage;
		
	}
}
