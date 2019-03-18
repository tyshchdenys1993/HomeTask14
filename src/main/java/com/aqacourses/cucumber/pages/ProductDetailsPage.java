package com.aqacourses.cucumber.pages;

import com.aqacourses.cucumber.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]")
    private WebElement breadCrumb;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductDetailsPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Get breadcrumb text
     * @return
     */
    public String getBreadCrumbText(){
       return breadCrumb.getText().replaceAll("[^a-zA-Z-\\s\\S]", "").trim();
    }

    /**
     * Get product name
     * @return
     */
    public String getProductName(){
        return productName.getText();
    }

    /** Method for adding product to cart */
    public void clickToAddToCartButton() {
        testClass.waitTillElementIsClickable(addToCartButton);
        addToCartButton.click();
    }

    /**
     * Method for proceeding to checkout
     *
     * @return
     */
    public ShoppingCartPage clickToProceedToCheckoutButton() {
        testClass.waitTillElementIsVisible(proceedToCheckOut);
        proceedToCheckOut.click();
        return new ShoppingCartPage(testClass);
    }
}
