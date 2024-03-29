package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sauce_Demo.Sauce_Demo.Abstract_Componant;

public class confirmationPage extends Abstract_Componant{
	
		WebDriver driver;
		public confirmationPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[normalize-space()='FINISH']")
		WebElement ConfirmFinish;
		
		@FindBy(css=".complete-header" )
		WebElement ConfirmMessage;
		
		public void finish() {
			
			ConfirmFinish.click();
		
		}
		
		public String getConfirmationMessage() {
			
			return ConfirmMessage.getText();
		}
		
}
