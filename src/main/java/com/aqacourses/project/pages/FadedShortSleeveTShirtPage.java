package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FadedShortSleeveTShirtPage extends AbstractPage {

    @FindBy (xpath = "//div[contains(@class,'breadcrumb')]")
    WebElement breadCrumb;

    @FindBy (xpath = "//button[@class='exclusive']")
    WebElement addToCardButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    private String breadCrumbText = "> Women>Tops>T-shirts>Faded Short Sleeve T-shirts";

    /**
     * Constructor
     *
     * @param testClass
     */
    public FadedShortSleeveTShirtPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Verify that bread crumb is correct
     */
    public void verifyBreadCrumb(){
        Assert.assertEquals(breadCrumb.getText(), breadCrumbText);
    }

    /**
     * Method for clicking to Add button
     */
    public void clickAddToCardButton(){
        addToCardButton.click();
    }

    /**
     * Click to Proceed to check out button
     * @return instance of shopping card page
     */
    public ShoppingCardPage clickToProceedToCheckOutButton(){
        testClass.waitTillElementIsVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new ShoppingCardPage(testClass);
    }


}
