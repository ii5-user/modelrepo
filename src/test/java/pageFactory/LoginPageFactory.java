package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testSuite.RunTestDeo;

public class LoginPageFactory {

	WebDriver driver;
	public static String HomePageUrl="http://125.99.96.8:4000/";
	public static String DataEntryUrl="http://125.99.96.8:4000/dataentry/#/task/";
	public LoginPageFactory(WebDriver ldriver) {
		// TODO Auto-generated constructor stub
		this.driver=ldriver;
	}


	@FindBy(id="username")
	@CacheLookup
	public
	WebElement username;

	@FindBy(how=How.ID_OR_NAME,using="password")
	@CacheLookup
	public
	WebElement password;

	@FindBy(xpath="//button")
	@CacheLookup
	public WebElement submitButton;

	public void login_asDeo()
	{
		username.sendKeys(RunTestDeo.DeoUserName);
		password.sendKeys(RunTestDeo.DeoPassword);
		submitButton.click();
	}

}
