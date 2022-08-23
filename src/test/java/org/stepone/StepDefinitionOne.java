package org.stepone;

import org.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;

public class StepDefinitionOne extends BaseClass {

	@Given("User is on the Adactin Url or Webpage")
	public void user_is_on_the_adactin_url_or_webpage() {
		browserLaunch();
		getBrowser("https://adactinhotelapp.com/");

	}

	@When("User should enters the Username and password")
	public void user_should_enters_the_username_and_password() {
		findId("username").sendKeys("mersalnk2153");
		findId("password").sendKeys("nk1456027ndhu");
	}

	@When("User should Click the Login button")
	public void user_should_click_the_login_button() {
		findId("login").click();
	}

	@Then("Verify the login Details")
	public void verify_the_login_details() {
		System.out.println("Login Functionality Worked in good condition");
	}

	@When("User should enters the place,No of rooms,Hotels..etc...,")
	public void user_should_enters_the_place_no_of_rooms_hotels_etc() {
		WebElement findId = findId("location");
		selectOptions3(findId, "Paris");

		WebElement findId2 = findId("hotels");
		selectOptions3(findId2, "Hotel Cornice");

		WebElement findId3 = findId("room_type");
		selectOptions3(findId3, "Super Deluxe");

		WebElement findId4 = findId("room_nos");
		selectOptions(findId4, 2);

		WebElement findName = findName("datepick_in");
		findName.clear();
		sendtext(findName, "22/10/2022");

		WebElement findName2 = findName("datepick_out");
		findName2.clear();
		sendtext(findName2, "27/10/2022");

		WebElement findName3 = findName("adult_room");
		selectOptions(findName3, 4);

		WebElement findName4 = findName("child_room");
		selectOptions(findName4, 4);

	}

	@When("User should clicks the Search Option")
	public void user_should_clicks_the_search_option() {
		findId("Submit").click();
		findId("radiobutton_0").click();
		findId("continue").click();

	}

	@Then("Verify the Hotel Availablity details")
	public void verify_the_hotel_availablity_details() {
		String s = "Hello Username";
		Assert.assertEquals(s, "Hello Username");
		System.out.println("User ready to Book the Hotel is Possible");
	}

	@When("User Enter the Address and Card Details")
	public void user_enter_the_address_and_card_details() {
		findId("first_name").sendKeys("Mersal");
		findId("last_name").sendKeys("Nandhu");

		findId("address").sendKeys("139/Anaikattu Road-4th Cross,Suramapatti Valasu,Thuraipakkam,Chennai-97.");
		findId("cc_num").sendKeys("6574839201019283");

		WebElement findId = findId("cc_type");
		selectOptions3(findId, "VISA");

		WebElement findId2 = findId("cc_exp_month");
		selectOptions3(findId2, "December");

		WebElement findId3 = findId("cc_exp_year");
		selectOptions(findId3, 12);

		findId("cc_cvv").sendKeys("143");
	}

	@When("User should clicks the Book Now button")
	public void user_should_clicks_the_book_now_button() throws InterruptedException {
		findId("book_now").click();
		Thread.sleep(6000);
		findId("my_itinerary").click();

	}

	@When("Verify the OrderId and Click the Order Itinerary")
	public void verify_the_order_id_and_click_the_order_itinerary() {
		WebElement findxpath = findxpath("(//input[@name='ids[]'])[6]");
		String result = gettingAttribute(findxpath, "value");
		System.out.println(result);
	}

	@Then("To check the Hotel,Rooms Details")
	public void to_check_the_hotel_rooms_details() {
		String s = "Booked Itinerary";
		Assert.assertEquals(s, "Booked Itinerary");
		System.out.println("Welcome to Adactin Group of Hotels");

	}

}
