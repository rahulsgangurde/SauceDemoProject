package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Sauce_Demo.Sauce_Demo.Abstract_Componant;

public class Product_Catalogue extends Abstract_Componant{
	
	WebDriver driver;
	public Product_Catalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="inventory_item_img")
	List<WebElement> products ;

	public List<WebElement> GetProductList() {
		
		return products;
	}
	
	@FindBy(xpath ="//div[@class='product_label']")
	WebElement ProductLabel;
	
	By addtoCart=By.xpath(
			"//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]");
	
	public WebElement GetProductName(String productName) {
		
		WebElement prod = GetProductList().stream()
				.filter(product -> product.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']"))
						.getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProducttoCart(String productName) {
	
		WebElement prod = GetProductName(productName);
		
		prod.findElement(addtoCart).click();
						
	}
	
	public String verifyproductLabel() {
		return ProductLabel.getText();
		
	}
}
