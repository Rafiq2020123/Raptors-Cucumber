package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.Base;

public class SouthwestPage extends Base {

	public SouthwestPage() {

		PageFactory.initElements(driver, this.getClass()); // Will initialize all the web elements of this class
	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'We found 2 results')]")
	private WebElement tempText;
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'$449.99')]")
	private WebElement southwestPrice;

	@FindBy(how = How.CSS, using = "[name =add-to-cart]")
	private WebElement addButton;

	@FindBy(how = How.XPATH, using = "//div[text()='1 in Cart']")
	private WebElement numbersofItemsInCart;

	@FindBy(how = How.CSS, using = "#cart-d")
	private WebElement cart;

	public boolean isSouthwestPriceDisplayed() {
		driverWait.until(ExpectedConditions.visibilityOf(tempText));
		return tempText.isDisplayed();
	}

	public void clickOnAddButton() {
		driverWait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	

	public boolean isNumberofIteminCartDisplayed() {
		driverWait.until(ExpectedConditions.visibilityOf(numbersofItemsInCart));
		return numbersofItemsInCart.isDisplayed();
	}

	public void clickOnCart() {
		driverWait.until(ExpectedConditions.elementToBeClickable(numbersofItemsInCart));
		cart.click();
	}

}
