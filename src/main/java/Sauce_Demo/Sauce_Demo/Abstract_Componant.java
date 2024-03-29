package Sauce_Demo.Sauce_Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Abstract_Componant {


	WebDriver driver;
	public Abstract_Componant(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
	WebElement CartHeader;
	
	public void GotoCartPage() {
		
		CartHeader.click();
		
	}
}
