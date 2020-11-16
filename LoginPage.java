package Combyne.testngframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

// Specify all objects in this class.

	WebDriver driver;

	By emailAddresstextBox = By.xpath("//input[@type='text']");

	By PasswordtextBox = By.xpath("//input[@type='password']");

	By NextButton = By.xpath("//input[@value='Next']");

	By ForgotYourPasswordLink = By.xpath("//div[text()='Forgot your password?']");

	By CreateAnAccount = By.xpath("//span[text()='Create an Account']");

	By ForgotPassWordHeader = By.xpath("//div[text()='Trouble Logging in?']");

	By LetsGetStartedTitle = By.xpath("//div[text()=\"Let's Get Started!\"]");

	By InvalidEmailErrormessage = By.xpath("//div[contains(text(),'That email is not associated with an account')]");

	By InvalidPasswordmessage = By.xpath("//div[contains(text(),'Incorrect Password')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

}
