package de.amazon.stepdefinitions;

import static de.amazon.utilities.Driver.*;

import de.amazon.pages.BasketPage;
import de.amazon.pages.HomePage;
import de.amazon.pages.SearchResultPage;
import de.amazon.utilities.ConfigReader;
import de.amazon.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AmazonTestStepDef {

    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    BasketPage basketPage = new BasketPage();

    @Given("As a new Amazon user, I am on the Amazon home page")
    public void as_a_new_amazon_user_i_am_on_the_amazon_home_page() {
        getDriver().get(ConfigReader.getProperty("amazon_url"));
        homePage.cookiesAkzeptierenButton.click();
    }

    @And("I search products and add the cheapest one to Einkaufswagen")
    public void i_search_and_add_the_cheapest_one_to_einkaufswagen(List<String> searchList) {

        for (String product : searchList) {
            homePage.searchProduct(product);
            searchResultPage.addToCartTheCheapestOne();
        }
    }

    @Given("I navigate to Einkaufswagen")
    public void i_navigate_to_Einkaufswagen() {
        homePage.menuEinKaufswagenButton.click();
    }

    @Then("verify that basket calculates the result correctly")
    public void verify_that_basket_calculates_the_result_correctly() {
        String expectedResult = basketPage.calculateBasketResult();
        String actualResult = basketPage.getAmountOfBasket();
        Assert.assertTrue(expectedResult.equals(actualResult));
    }

    @Then("I navigate to checkout")
    public void i_navigate_to_checkout() {
        basketPage.zurKasseGehenButton.click();
    }

    @Then("verify that user gets redirected to registration page")
    public void verify_user_gets_redirected_to_registration_page() {
        String expectedPageTitle = "Amazon Registirierung";
        String actualPageTitle = getDriver().getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }


}
