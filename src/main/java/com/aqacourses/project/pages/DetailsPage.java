package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends AbstractPage {

    private String PRODUCT_COLOR_XPATH = "//a[@name='%s']";
    private String PRODUCT_SIZE_XPATH = "//select[@id='group_1']/option[@title='%s']";

    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]")
    private WebElement breadCrumb;

    @FindBy(xpath = "//button[@class='exclusive']")
    private WebElement addToCardButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement sizesDropDownList;

    /**
     * Constructor
     *
     * @param testClass
     */
    public DetailsPage(BaseTest testClass) {
        super(testClass);
    }

    /** Verify that bread crumb is correct */
    public void verifyBreadCrumb(String breadCrumbText) {
        Assert.assertEquals(
                breadCrumbText + productName.getText(),
                breadCrumb.getText().replaceAll("[^a-zA-Z-\\s]", "").trim());
    }

    /** Method for clicking to Add button */
    public void clickAddToCardButton() {
        addToCardButton.click();
    }

    /**
     * Click to Proceed to check out button
     *
     * @return instance of shopping card page
     */
    public ShoppingCardPage clickToProceedToCheckOutButton() {
        testClass.waitTillElementIsVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new ShoppingCardPage(testClass);
    }

    /** Click to Continue Shopping Button */
    public void clickToContinueShoppingButton() {
        testClass.waitTillElementIsVisible(continueShoppingButton);
        continueShoppingButton.click();
    }

    /**
     * Click to appropriate product color
     *
     * @param productColor
     */
    public void selectProductColor(String productColor) {
        testClass.waitTillElementIsVisible(
                testClass
                        .getDriver()
                        .findElement(By.xpath(String.format(PRODUCT_COLOR_XPATH, productColor))));
        testClass
                .getDriver()
                .findElement(By.xpath(String.format(PRODUCT_COLOR_XPATH, productColor)))
                .click();
    }

    /**
     * Click to appropriate product size
     *
     * @param productSize
     */
    public void selectProductSize(String productSize) {
        sizesDropDownList.click();
        testClass
                .getDriver()
                .findElement(By.xpath(String.format(PRODUCT_SIZE_XPATH, productSize)))
                .click();
    }
}
