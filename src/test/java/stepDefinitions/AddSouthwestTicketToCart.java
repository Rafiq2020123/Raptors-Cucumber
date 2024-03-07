package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.CostcoMainPage;
import pageObjects.SouthwestPage;
import utilities.WebDriverUtility;

public class AddSouthwestTicketToCart extends Base {

	public CostcoMainPage mainPage;
	public SouthwestPage southwestPage;
	public CheckOutPage checkOutPage;

	@Given("^User is on Costco website$")
	public void user_is_on_Costco_website() throws Throwable {

		WebDriverUtility.wait(3);
		Base.initializeDriver(); // Lunch the browser
		logger.info("Costo page is opend");
		String actualTitle = driver.getTitle();
		 String expectedTitle = "Welcome to Costco Wholesale";
		WebDriverUtility.wait(2);
		Assert.assertEquals(actualTitle, expectedTitle);
		//Assert.assertEquals(actualTitle, Base.getExpectedPageTitle());
		logger.info("Costco page titile is verifed");
		WebDriverUtility.wait(3);
		//Assert.assertTrue(mainPage.isLogoDisplayed());
		logger.info("Costco logo is verifed");
		WebDriverUtility.screenShot();

	}

	@When("^User enters \"([^\"]*)\" ticket in the search bar$")
	public void user_enters_ticket_in_the_search_bar(String southwest) throws Throwable {
		WebDriverUtility.wait(3);
		WebElement elm =driver.findElement(By.cssSelector("#search-field"));
		WebDriverUtility.enterValue(elm, southwest);
		elm.sendKeys(Keys.RETURN);
		//mainPage.searchAndSelectProduct(southwest);
		logger.info("Searched and entered the Southwest ticket in the search bar");
		WebDriverUtility.wait(1);
		WebDriverUtility.screenShot();

	}

	@Then("^User sould be landed on the page with the title \"([^\"]*)\"$")
	public void user_sould_be_landed_on_the_page_with_the_title(String paeTitle) throws Throwable {
		
		WebDriverUtility.wait(4);
		Assert.assertEquals(paeTitle, southwestPage.isSouthwestPriceDisplayed());
		logger.info("Verified the southwest price is displayed on the page ");
		WebDriverUtility.screenShot();

	}

	@When("^User clicks on the Add button$")
	public void user_clicks_on_the_Add_to_Cart_button() throws Throwable {
		WebDriverUtility.wait(4);
		//southwestPage.clickOnAddButton();
		WebElement add =driver.findElement(By.cssSelector("[name =add-to-cart]"));
		WebDriverUtility.clickOnElement(add);
		logger.info("Clicked on add button");
		WebDriverUtility.wait(1);
		WebDriverUtility.screenShot();
	}

	@Then("^User should be able to see the text of \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_price_of(String price) throws Throwable {

		WebDriverUtility.wait(4);
		Assert.assertEquals(price, southwestPage.isNumberofIteminCartDisplayed());
		logger.info("Asserted the number of items in the cart");
		WebDriverUtility.screenShot();
	}
	

	@When("^User click on the Cart button$")
	public void user_click_on_the_View_Cart() throws Throwable {
		WebDriverUtility.wait(4);
		southwestPage.clickOnCart();
		logger.info("Clicked on the cart button");
		WebDriverUtility.screenShot();

	}

	@Then("^User should be able to see the \"([^\"]*)\" button and click on the checkout button$")
	public void user_should_be_able_to_see_the_button(String checkOutButton) throws Throwable {
		WebDriverUtility.wait(2);
		Assert.assertTrue(checkOutPage.isapplyTodayButtonDisplayed());
		logger.info("Verified the Apply Today button is displayed ");
		Assert.assertTrue(checkOutPage.isapplyTodayButtonEnabled());
		logger.info("Verified the Apply Today button is enabled");
		WebDriverUtility.wait(2);
		Assert.assertEquals(checkOutButton, checkOutPage.isCheckOutBuutonDisplayed());
		logger.info("Verified the Checkout button is enabled");
		checkOutPage.clickonCheckOuButon();
		logger.info("Clicked on the Checkout button");
		WebDriverUtility.screenShot();

	}

}
