Feature: Verify the Adactin Booking Details
Scenario: Verify the Login Page Valid Credential
	Given User is on the Adactin Url or Webpage
	When User should enters the Username and password
	And User should Click the Login button
	Then Verify the login Details
	When User should enters the place,No of rooms,Hotels..etc...,
	And User should clicks the Search Option
	Then Verify the Hotel Availablity details	
	When User Enter the Address and Card Details
	And User should clicks the Book Now button
	And Verify the OrderId and Click the Order Itinerary
	Then To check the Hotel,Rooms Details
	
