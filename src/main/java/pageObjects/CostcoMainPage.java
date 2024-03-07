package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.Base;
import utilities.WebDriverUtility;

public class CostcoMainPage extends Base {

	// We create a constructor for this page class and this will be applied to all
	// the pages elements

	public CostcoMainPage() {

		PageFactory.initElements(driver, this.getClass()); // Will initialize all the web elements of this class
	}
	

	// PageFactory class provides @FindBy annotation to find UI elements.
	// driver.findElement(by.xpath("//tag[@attribute='value']"))
	// the above code is same as below but, below code is used to implement
	// PageFactory in POM Design pattern
	// @FindBy(how = How.xpath, using = "//tag[@attribute= 'value'])
	// we will store these elements as a private WebElement to implement
	// Encapsulation

	@FindBy(css = "#search-field")
	private WebElement searchBar;

	@FindBy(how = How.ID, using = "headerCostcoLogo")
	private WebElement logo;
	// By logg = By.id("headerCostcoLogo");

	public boolean isLogoDisplayed() {
		driverWait.until(ExpectedConditions.visibilityOf(logo));
		WebDriverUtility.isElementDisplayed(logo);
		return logo.isDisplayed();
		
	}

	public void searchAndSelectProduct(String item) {
		driverWait.until(ExpectedConditions.visibilityOf(searchBar));
		//WebDriverUtility.clearText(searchBar);
		searchBar.sendKeys(item);
		WebDriverUtility.enterValue(searchBar, item);
		//searchBar.sendKeys(Keys.RETURN);

	}

}
