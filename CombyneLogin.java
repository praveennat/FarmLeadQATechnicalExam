package Combyne.testngframework;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CombyneLogin

{
	String PropertyPath = "D:\\browserdrivers\\chromedriver.exe";
	String PropertyName = "webdriver.chrome.driver";
	String URL = "https://demo.combyne.ag/login";
	LoginPage loginpage;
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void LoginPageLaunch() {
		System.setProperty(PropertyName, PropertyPath);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

	@Parameters({ "EmailAddress", "Password" })
	@Test
	public void LOGIN_001(String EmailAddress, String Password) // successful login
	{
		loginpage = new LoginPage(driver);
		loginpage.driver.findElement(loginpage.emailAddresstextBox).sendKeys(EmailAddress);
		loginpage.driver.findElement(loginpage.PasswordtextBox).sendKeys(Password);
		loginpage.driver.findElement(loginpage.NextButton).click();

	}

	@Test
	public void LOGIN_002() // Forgot password
	{
		loginpage = new LoginPage(driver);
		loginpage.driver.findElement(loginpage.ForgotYourPasswordLink).click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginpage.emailAddresstextBox));

	}

	@Test
	public void LOGIN_003() // create an account
	{
		loginpage = new LoginPage(driver);
		loginpage.driver.findElement(loginpage.CreateAnAccount).click();
		Assert.assertEquals(true, driver.findElement(loginpage.LetsGetStartedTitle).isDisplayed());

	}

	@Parameters({ "InvalidEmailAddress" })
	@Test
	public void LOGIN_005(String InvalidEmailAddress) // Invalid email address.
	{
		loginpage = new LoginPage(driver);
		loginpage.driver.findElement(loginpage.emailAddresstextBox).sendKeys(InvalidEmailAddress);
		loginpage.driver.findElement(loginpage.NextButton).click();
		String InvalidEmailErrormessageText = driver.findElement(loginpage.InvalidEmailErrormessage).getText();
		assertTrue(InvalidEmailErrormessageText.contains("email is not associated with an account"));

	}

	// LOGIN_006: It was observed that the application displays same error message
	// as in test case LOGIN_005().

	@Parameters({ "EmailAddress", "InvalidPassword" })
	@Test
	public void LOGIN_007(String EmailAddress, String InvalidPassword) // Invalid password
	{
		loginpage = new LoginPage(driver);
		loginpage.driver.findElement(loginpage.emailAddresstextBox).sendKeys(EmailAddress);
		loginpage.driver.findElement(loginpage.PasswordtextBox).sendKeys(InvalidPassword);
		loginpage.driver.findElement(loginpage.NextButton).click();
		String InvalidPasswordmessageText = driver.findElement(loginpage.InvalidPasswordmessage).getText();
		assertTrue(InvalidPasswordmessageText.contains("Incorrect Password"));

	}

}
