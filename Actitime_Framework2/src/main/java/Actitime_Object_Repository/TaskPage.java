package Actitime_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	@FindBy(xpath = "//a[.='Projects & Customers']")
	private WebElement Projectcustomerlink;

	TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void Projectandcustomer() {
		Projectcustomerlink.click();
	}
}
