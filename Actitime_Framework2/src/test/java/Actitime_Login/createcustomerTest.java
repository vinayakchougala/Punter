package Actitime_Login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Actitime_Object_Repository.CreatecustomerPage;
import Actitime_Object_Repository.HomePage;
import Actitime_Object_Repository.LoginPage;
import Actitime_Object_Repository.ProjectandcustomerlinkPage;
import Aldi_generic_utility.ExcelUtlity;
import Aldi_generic_utility.FileUtlity;
import Aldi_generic_utility.JavaUtlity;
import Aldi_generic_utility.WebActionUtility;

public class createcustomerTest {
	@Test
	public void createcust() throws Throwable {
		/* Create Object for Property File and Excel File */
		FileUtlity Flib = new FileUtlity();
		ExcelUtlity Elib = new ExcelUtlity();
		JavaUtlity Jlib = new JavaUtlity();
		WebActionUtility Wlib = new WebActionUtility();

		/* Fetch commondata from property file */
		String filepath = Flib.getFilePathFromPropertiesFile("Actitimecommondatafilepath");
		String BROWSER = Flib.getDataFromProperties(filepath, "browser");
		String URL = Flib.getDataFromProperties(filepath, "url");
		String USERNAME = Flib.getDataFromProperties(filepath, "username");
		String PASSWORD = Flib.getDataFromProperties(filepath, "password");

		/* Launch the browser */
		WebDriver driver;
		if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}

		Wlib.waitForElementInDOM(driver);

		driver.get(URL);
		driver.manage().window().maximize();

		/* Login to application */
		/*
		 * driver.findElement(By.id("username")).sendKeys(USERNAME);
		 * driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		 * driver.findElement(By.xpath("//div[.='Login ']")).click();
		 */
		LoginPage LP = new LoginPage(driver);
		LP.Logincredential(USERNAME, PASSWORD);

		/* navigate through task */
		/*
		 * driver.findElement(By.xpath("//a[@class='content tasks']")).click();
		 * driver.findElement(By.xpath("//a[.='Projects & Customers']")).click();
		 * driver.findElement(By.id("createCustomerDiv")).click();
		 */

		HomePage HP = new HomePage(driver);
		HP.Taskbutton();

		ProjectandcustomerlinkPage PACLP = new ProjectandcustomerlinkPage(driver);
		PACLP.Createcustomerbutton();

		int ran = Jlib.getRandomNumber();

		/* Fetch commondata from Excel file */
		String filepath1 = Flib.getFilePathFromPropertiesFile("TestScriptdatafilePath");
		String NAME = Elib.getDataFromExcelBasedTestId(filepath1, "actitime", "tc_01", "Name");
		String DESCRIPTION = Elib.getDataFromExcelBasedTestId(filepath1, "actitime", "tc_01", "Description");

		/* Create Customer */
		/*
		 * driver.findElement(By.name("name")).sendKeys(NAME + ran);
		 * driver.findElement(By.name("description")).sendKeys(DESCRIPTION);
		 * driver.findElement(By.name("createCustomerSubmit")).click();
		 */

		CreatecustomerPage CCP = new CreatecustomerPage(driver);
		CCP.Customertextfiled(NAME + ran, DESCRIPTION);

		WebElement ele4 = driver.findElement(By.xpath("//span[@class='successmsg']"));
		String actmsg = ele4.getText();
		System.out.println(actmsg);
		WebElement ele1 = driver.findElement(By.xpath("//select[@name='selectedCustomer']"));
		Select s = new Select(ele1);

		List<WebElement> allop = s.getOptions();
		ArrayList<String> l = new ArrayList<String>();
		for (WebElement we1 : allop) {
			String alltext = we1.getText();
			l.add(alltext);
		}
		if (l.contains(NAME + ran)) {
			System.out.println("Customer is created------>Pass");

		}

		else {
			System.out.println("customer is not created------>fail");
		}

		WebElement ele3 = driver.findElement(By.xpath("//select[@name='recordsPerPage']"));
		Wlib.select(ele3, 5);

		List<WebElement> ele = driver
				.findElements(By.xpath("//th[@class='listtblcolheader firstInRow leftAligned']/../.."));

		for (WebElement we : ele) {
			String Act_Text = we.getText();

			if (Act_Text.contains(NAME + ran)) {
				System.out.println("Customer is created------->pass");
				break;
			} else {
				System.out.println("customer is not created------>fail");
			}

		}
		driver.findElement(By.xpath("//a[.='Logout']")).click();

		driver.close();

	}
}
