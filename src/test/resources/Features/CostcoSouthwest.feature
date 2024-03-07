
Feature: Login to Costco Website 

	
	
	
	
	
	
	
	
Scenario: Add a Southwest ticket to the cart 

Given User is on Costco website 
When User enters "Southwest" ticket in the search bar
Then User sould be landed on the page with the title "We found 2 results for \"southwest\"" 
When User clicks on the Add button
Then User should be able to see the text of "1 in Cart" 
When User click on the Cart button
Then User should be able to see the "Checkout" button and click on the checkout button
		
		
	