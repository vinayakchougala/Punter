package Actitime_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectandcustomerlinkPage {
	@FindBy(xpath = "//a[.='Projects & Customers']")
	private WebElement projectcustbtn;

	@FindBy(id = "createCustomerDiv")
	private WebElement Createcustomerbtn;

	public ProjectandcustomerlinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void Createcustomerbutton() {
		projectcustbtn.click();
		Createcustomerbtn.click();
	}
}
