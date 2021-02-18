package de.amazon.pages;

import de.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;
import java.util.List;

public class BasketPage {
    public BasketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="sc-subtotal-amount-buybox")
    public WebElement amountOfBasket;

    @FindBy(name = "proceedToRetailCheckout")
    public WebElement zurKasseGehenButton;

    @FindBy(className = "sc-product-price")
    public List<WebElement> basketProductPrices;

    /**
     * Get the amount without symbol
     * @return
     */
    public String getAmountOfBasket(){
        return String.valueOf(convertToDouble(amountOfBasket.getText()));
    }

    /**
     * Calculate the result of basket as double and then convert to string as return value
     * @return
     */
    public String calculateBasketResult() {
        double sum = 0;
        for (WebElement price : basketProductPrices) {
            double temp= convertToDouble(price.getText());
            sum+=temp;
        }
        return String.valueOf(sum);
    }

    /**
     * Convert the price which is string to double
     * @param priceText
     * @return
     */
    public double convertToDouble(String priceText) {
        DecimalFormat df = new DecimalFormat("#.##");
        double num = Double.parseDouble(priceText.substring(0,priceText.length()-2).replace(',','.'));
        df.format(num);
        return num;
    }



}
