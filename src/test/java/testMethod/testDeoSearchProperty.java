package testMethod;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import helper.BrowserFactory;
import helper.reUsableMethod;
import pageFactory.LoginPageFactory;
import testSuite.RunTestDeo;

public class testDeoSearchProperty {
	//WebDrive
    //Extents Reports
	static ExtentReports report=new ExtentReports("E:\\report.html",false);
	static ExtentTest testLogin;
	static WebDriver driver=BrowserFactory.startBrowser("chrome");
	static WebDriverWait wait=new WebDriverWait(driver,20);
	static LoginPageFactory inLoginPage;

	
	public static void openUrl() throws IOException
	{
		testLogin= report.startTest("Open Login Url");
		driver.get(LoginPageFactory.HomePageUrl);
		testLogin.log(LogStatus.INFO, "Login Url Open");
		reUsableMethod.captureScreenMethod(driver);
		testLogin.log(LogStatus.PASS, "ScreenShots of Login Page"+testLogin.addScreenCapture(reUsableMethod.dest));
		inLoginPage=PageFactory.initElements(driver, LoginPageFactory.class);
		inLoginPage.login_asDeo();
		RunTestDeo.testCaseSheet.getRow(RunTestDeo.r).createCell(3).setCellValue("New");

		report.endTest(testLogin);
		report.flush();
			
	}
	
	
	
}
