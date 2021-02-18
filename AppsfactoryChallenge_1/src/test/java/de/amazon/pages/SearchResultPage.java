package de.amazon.pages;

import de.amazon.utilities.Driver;
import de.amazon.utilities.ReusableMethods;
import org.apache.hc.client5.http.psl.PublicSuffixList;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage {
    public SearchResultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "s-result-sort-select")
    public WebElement sortierenNachDDList;

    @FindBy(xpath = "//*[@data-component-type=\"s-search-result\"]//img")
    public WebElement firstProductOfSearchResult;

    @FindBy(id="buybox-see-all-buying-choices-announce")
    public WebElement alleAngeboteButton;

    @FindBy(name = "submit.addToCart")
    public WebElement anbieterInDenEinkaufswagenButton;

    @FindBy(id="add-to-cart-button")
    public WebElement direktInDenEinkaufswagenButton;

    /**
     *Adds the cheapest product to cart
     */
    public void addToCartTheCheapestOne() {
        Select options = new Select(sortierenNachDDList);
        options.selectByIndex(1);
        ReusableMethods.waitForClickablility(firstProductOfSearchResult,5);
        firstProductOfSearchResult.click();
        try {
           direktInDenEinkaufswagenButton.click();
        } catch (Exception e) {
            if (e.getMessage().contains("no such element")) {
             alleAngeboteButton.click();
             anbieterInDenEinkaufswagenButton.click();
            }
        }
    }
}
