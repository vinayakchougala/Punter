package Actitime_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecustomerPage {
	@FindBy(name = "name")
	private WebElement Customernametextfield;

	@FindBy(name = "description")
	private WebElement descriptiontextfield;

	@FindBy(name = "createCustomerSubmit")
	private WebElement createcustomerbutton;

	public CreatecustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void Customertextfiled(String name, String description) {
		Customernametextfield.sendKeys(name);
		descriptiontextfield.sendKeys(description);
		createcustomerbutton.click();
	}

}
