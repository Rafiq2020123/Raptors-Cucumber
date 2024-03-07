package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.Base;

public class CheckOutPage extends Base {

	public CheckOutPage() {

		PageFactory.initElements(driver, this.getClass()); // Will initialize all the web elements of this class
	}

	@FindBy(how = How.CSS, using = "[value='Apply Today']")
	private WebElement applyTodayButton;

	@FindBy(how = How.CSS, using = "#shopCartCheckoutSubmitButton")
	private WebElement checkOutBuuton;

	
	public boolean isapplyTodayButtonDisplayed() {
    driverWait.until(ExpectedConditions.visibilityOf(applyTodayButton));
		return applyTodayButton.isDisplayed();
	}

	public boolean isapplyTodayButtonEnabled() {
		 driverWait.until(ExpectedConditions.visibilityOf(applyTodayButton));
		return applyTodayButton.isEnabled();
	}

	public boolean isCheckOutBuutonDisplayed() {
		 driverWait.until(ExpectedConditions.visibilityOf(applyTodayButton));
		return checkOutBuuton.isDisplayed();
	}

	public void clickonCheckOuButon() {
		 driverWait.until(ExpectedConditions.elementToBeClickable(checkOutBuuton));
		checkOutBuuton.click();
	}

}
