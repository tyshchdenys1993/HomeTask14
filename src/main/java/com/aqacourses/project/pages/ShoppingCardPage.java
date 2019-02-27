package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCardPage extends AbstractPage {

    @FindBy (xpath = "//a[@title='Add']")
    WebElement increaseQuantityButton;

    @FindBy (xpath = "//input[contains(@class,'cart_quantity_input form-control')]/preceding-sibling::input")
    WebElement quantityField;

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    WebElement unitPrice;

    @FindBy (xpath = "//td[@class='cart_total']/span")
    WebElement totalPrice;

    @FindBy (xpath = "//a[@title='Delete']")
    WebElement deleteFadedTShort;

    @FindBy (xpath = "//p[contains(@class,'alert-warning')]")
    WebElement alertField;

    private String alertMessage = "Your shopping cart is empty.";

    /**
     * Constructor
     *
     * @param testClass
     */
    public ShoppingCardPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Method for increasing quantity of products
     */
    public void clickToIncreaseQuantityButton(){
        increaseQuantityButton.click();
    }

    /**
     * Method for verifying total price after increasing quantity of products
     */
    public void verifyPriceIncreasing(){
        double totalPriceField = Double.valueOf(totalPrice.getText().replace("$",""));
        double priceForUnitMultipliedQuantity = Double.valueOf(unitPrice.getText().replace("$",""))
                *Double.valueOf(quantityField.getAttribute("value"));
        Assert.assertEquals(totalPriceField, priceForUnitMultipliedQuantity, 0);

    }

    /**
     * Method for deleting added product
     */
    public void clickDeleteFadedTShort (){
        deleteFadedTShort.click();
    }

    /**
     * Method for verifying alert message
     */
    public void verifyAlertMessage(){
        testClass.waitTillElementIsVisible(alertField);
        Assert.assertEquals(alertMessage, alertField.getText());
    }
}
