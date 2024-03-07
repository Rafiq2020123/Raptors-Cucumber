package stepDefinitions;

import java.time.Duration;

import org.apache.hc.client5.http.cookie.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer extends Base {

	
	// Cucumber provides Hooks and we have four Hooks
	// Before Hooks and After Hooks
	// BeforeStep Hooks and AfterStep Hooks
	// Before Hooks uses @Before tag and will run block of code before each scenario
	// in Before Hooks we usually define block of codes to initialize browser
	// manage webdriver
	// log scenario name
	// After Hooks uses @After tag and will run block of code after each scenario
	// in After Hooks we usually define block of codes to get scenario status
	// and tear down or close browser.

	@Before
	public void beforeHooks(Scenario scenario) {

		// before each scenario we can print or log the name of scenario we will execute
		logger.info("Scenario " + scenario.getName() + " Started ");
		// we write a switch statement to create object of browsers (Chrome, IE,
		// Firefox)

		// We use WebdriverManager to replace System.setProperty(driver and executable
		// file)

		String browser = getBrowserName();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
     

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@After
	public void afterHooks(Scenario scenario) {
		// tear down will close browser and all tabs after each execution.
		tearDown();
		// get status of execution and log it
		logger.info(scenario.getName() + "   " + scenario.getStatus());

	}

}
