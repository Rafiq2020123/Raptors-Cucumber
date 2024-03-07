package core;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	// In this class we will be defining properties of the below Classes and will be
	// using them in their child classes

	public static WebDriver driver;
	protected static WebDriverWait driverWait;
	public static Properties propertise;
	public static Logger logger;
	private String PropertyFilePath = ".\\src\\test\\resources\\InputData\\Prop.properties";
	private String log4JFilePath = ".\\src\\test\\resources\\InputData\\log4j.properties";

	public Base() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(PropertyFilePath));
			propertise = new Properties();
			propertise.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		logger = logger.getLogger("logger_File");
		//PropertyConfigurator.configure(log4JFilePath);
		
		PropertyConfigurator.configure(log4JFilePath);
		
		
	}

	/**
	 * This method will return value of browser name such as Chrome, Firefox, IE,
	 * and Headless browser
	 * 
	 * @return
	 */
	public static String getBrowserName() {
		String browserName = propertise.getProperty("browser");
		return browserName;

	}

	/**
	 * This method will return the url of application we use for this Framework.
	 * 
	 * @return
	 */

	public static String getURL() {
		String url = propertise.getProperty("url");
		return url;
	}

	public static String getExpectedPageTitle() {
		String pageTitle = propertise.getProperty("ExpectedPageTittle");
		return pageTitle;
	}

	/**
	 * This method will return implicitly wait time and parse it to long data type
	 * as Implicitly wait method in selenium accepts Long dataType.
	 * 
	 * @return
	 */
	public static Long getImpWait() {
		String imptWait = propertise.getProperty("implicitlyWait");
		return Long.parseLong(imptWait);
	}

	/**
	 * This method will return pageLoadTime Out wait time and parse it to long data
	 * type as pageLoadTime wait method in selenium accepts Long dataType.
	 * 
	 * @return
	 */
	public static Long getPageLoadTimeOut() {
		String pageLTimeOut = propertise.getProperty("pageLoadTimeOut");
		return Long.parseLong(pageLTimeOut);
	}

	/**
	 * This method will initialize the webdriver whenever we call it.
	 */
	public static void initializeDriver() {
		driver.get(getURL());
	}

	/**
	 * This method will Close and quite all windows after each execution.
	 */
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

	public static void waitUntilElementIsDIsplayed(By theElement) {
		driverWait.until(ExpectedConditions.visibilityOf((WebElement) theElement));
		driver.findElement(theElement).isDisplayed();
	}

}
