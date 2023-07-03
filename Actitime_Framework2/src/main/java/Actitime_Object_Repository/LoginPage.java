package Actitime_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	/* Declaration */
	@FindBy(id = "username")
	private WebElement usernametextfield;

	@FindBy(name = "pwd")
	private WebElement passwordtextfield;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginbutton;

	/* Initialisation */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Business Libraries */
	public void Logincredential(String username, String password) {
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);
		loginbutton.click();
	}

}
