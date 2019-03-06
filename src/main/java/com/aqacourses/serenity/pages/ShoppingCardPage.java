package com.aqacourses.serenity.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ShoppingCardPage extends AbstractPage{

    WebDriverWait wait =  new WebDriverWait(getDriver(),10);

    @FindBy(xpath = "//a[@title='Add']")
    private WebElement increaseQuantityButton;

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
     * @param driver
     */
    public ShoppingCardPage(WebDriver driver) {
        super(driver);
    }
    /** Method for increasing quantity of products */
    public void clickToIncreaseQuantityButton(){
        increaseQuantityButton.click();
        int increasedQuantity = Integer.valueOf(getDriver().findElement(By
                .xpath("//input[contains(@class,'cart_quantity_input form-control')]/preceding-sibling::input"))
                .getAttribute("value")) +1;
        wait.until(ExpectedConditions.attributeToBe(getDriver().findElement(By
                .xpath("//input[contains(@class,'cart_quantity_input form-control')]/preceding-sibling::input"))
                , "value"
                , String.valueOf(increasedQuantity)));
    }

    /** Method for verifying total price after increasing quantity of products */
    public void verifyPriceIncreasing() {
        double totalPriceField = Double.valueOf(totalPrice.getText().replace("$", ""));
        double priceForUnitMultipliedQuantity =
                Double.valueOf(unitPrice.getText().replace("$", ""))
                        * Double.valueOf(getDriver().findElement(By
                        .xpath("//input[contains(@class,'cart_quantity_input form-control')]/preceding-sibling::input"))
                        .getAttribute("value"));
        Assert.assertEquals(totalPriceField, priceForUnitMultipliedQuantity, 0);
    }

  /** Method for deleting added product */
  public void clickDeleteFadedTShort() {
    deleteFadedTShort.click();
    waitFor(visibilityOf(alertField));
  }

    /** Method for verifying alert message */
    public void verifyAlertMessage() {
        Assert.assertEquals(alertMessage, alertField.getText());
    }
}
