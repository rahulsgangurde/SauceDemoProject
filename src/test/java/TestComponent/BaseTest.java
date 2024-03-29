package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage ;
	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Windows 10//eclipse-workspace//Sauce_Demo//src//main//java//Resources//globalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

		 driver = new ChromeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
		
	}
	@BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver= InitializeDriver();
		 loginPage = new LoginPage(driver);
		loginPage.Visit();
		return loginPage;
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//"+ testCaseName +".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+ "//reports//"+ testCaseName +".png";
	}
}
