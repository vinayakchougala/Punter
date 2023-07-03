package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Aldi_generic_utility.FileUtlity;
import Aldi_generic_utility.WebActionUtility;

public class Implicitywait
{
	public static void main(String[] args) throws Throwable
	{
		FileUtlity Flib = new FileUtlity();
		WebActionUtility Wlib = new WebActionUtility();
	      WebDriver driver = new ChromeDriver();
	      Wlib.waitForElementInDOM(driver);
	      driver.get("https://www.amazon.in");
	}

}
