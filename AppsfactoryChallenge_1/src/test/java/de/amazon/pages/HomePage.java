package de.amazon.pages;

import de.amazon.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(id="sp-cc-accept")
    public WebElement cookiesAkzeptierenButton;

    @FindBy(id="nav-cart-text-container")
    public WebElement menuEinKaufswagenButton;

    /**
     * Search a product
     * @param product
     */
    public void searchProduct(String product){
        searchTextBox.clear();
        searchTextBox.sendKeys(product, Keys.ENTER);
    }
}
