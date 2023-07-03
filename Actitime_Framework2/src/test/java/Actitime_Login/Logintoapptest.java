package Actitime_Login;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Aldi_generic_utility.ExcelUtlity;
import Aldi_generic_utility.FileUtlity;
import Aldi_generic_utility.WebActionUtility;

public class Logintoapptest{
	@Test
	public void open() throws Throwable {

		/*
		 * JSONParser jsp = new JSONParser(); Object ob = jsp.parse(new
		 * FileReader("./jsondata/shopper.json"));
		 * 
		 * JSONObject map =(JSONObject)ob;
		 * 
		 * String BROWSER=(String)(map.get("browser")); String
		 * URL=(String)(map.get("url")); String USERNAME=(String)(map.get("username"));
		 * String PASSWORD=(String)(map.get("password"));
		 */

		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wau = new WebActionUtility();

		/* get the FILE PATH */
		String ENV_FILE_PATH = fLib.getFilePathFromPropertiesFile("ProjectCommonDataFilePath");

		/* Read the common data */
		String BROWSER = fLib.getDataFromProperties(ENV_FILE_PATH, "browser");
		String URL = fLib.getDataFromProperties(ENV_FILE_PATH, "url");
		String USERNAME = fLib.getDataFromProperties(ENV_FILE_PATH, "username");
		String PASSWORD = fLib.getDataFromProperties(ENV_FILE_PATH, "password");
		
		/*Read the Excel data*/
		String filepath1 = fLib.getFilePathFromPropertiesFile("TestScriptdatafilePath");
		String PRODUCTNAME = eLib.getDataFromExcelBasedTestId(filepath1,"shopper","tc_01","Productname");
		

		// open application in different browsers

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}

	    wau.waitForElementInDOM(driver);
		driver.get(URL);
		driver.manage().window().maximize();

		// Login to application

	  wau.waitAndClick(driver.findElement(By.xpath("//button[@name='loginBtn']")));
	  		driver.findElement(By.name("Email")).sendKeys(USERNAME);
		driver.findElement(By.name("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//span[.='Login']")).click();
		


		/* search for one Product*/
		 
         wau.waitAndType(driver.findElement(By.name("search")),PRODUCTNAME);
         wau.waitForElement(driver,driver.findElement(By.name("searchBtn")));

          driver.findElement(By.name("searchBtn")).click();
	 
	

		/*verify for searched product is displayed or not*/
		  
	   
       wau.waitForPage(driver, "search-products/shoes");
       
		WebElement text = driver.findElement(By.xpath("//span[.='Puma sports shoe']"));
		

		String Act_msg = text.getText();
		System.out.println(Act_msg);

		String Exp_msg = "Puma sports shoe";
		if (Act_msg.equalsIgnoreCase(Exp_msg)) {
			System.out.println("Searched Product is displayed----Pass");
		} else {
			System.out.println("searched Product is not be displayed----Fail");
		}
		driver.close();

	}

}
