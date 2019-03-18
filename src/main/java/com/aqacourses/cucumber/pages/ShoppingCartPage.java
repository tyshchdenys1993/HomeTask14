package com.aqacourses.cucumber.pages;

import com.aqacourses.cucumber.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {
    @FindBy(xpath = "//a[@title='Add']")
    private WebElement increaseQuantityButton;

    @FindBy(
            xpath =
                    "//input[contains(@class,'cart_quantity_input form-control')]/preceding-sibling::input")
    private WebElement quantityField;

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    private WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']/span")
    private WebElement totalPrice;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteFadedTShort;

    @FindBy(xpath = "//p[contains(@class,'alert-warning')]")
    private WebElement alertField;

    private String alertMessage = "Your shopping cart is empty.";
    /**
     * Constructor
     *
     * @param testClass
     */
    public ShoppingCartPage(BaseTest testClass) {
        super(testClass);
    }

    /** Method for increasing quantity of products */
    public void clickToIncreaseQuantityButton() {
        increaseQuantityButton.click();
        int increasedQuantity = Integer.valueOf(quantityField.getAttribute("value")) + 1;
        testClass.waitTillAttributeIsChanged(
                quantityField, "value", String.valueOf(increasedQuantity));
    }

    /**
     * Get total price (price multiplied with quantity)
     * @return
     */
    public Double getTotalPrice(){
        return Double.valueOf(unitPrice.getText().replace("$", ""))
                * Double.valueOf(quantityField.getAttribute("value"));
    }

    /** Method for deleting added product */
    public void clickDeleteFadedTShort() {
        deleteFadedTShort.click();
    }

    /**
     * Get text from alert message
     * @return
     */
    public String getAlertMessage(){
        testClass.waitTillElementIsVisible(alertField);
        return alertField.getText();
    }
}
