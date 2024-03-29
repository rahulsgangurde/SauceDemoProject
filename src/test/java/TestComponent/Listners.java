package TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.extentReportNG;

public class Listners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extentReports =extentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extenLocal = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test=extentReports.createTest(result.getMethod().getMethodName());
		extenLocal.set(test);
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extenLocal.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
				
		
		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenLocal.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extenLocal.get().log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
