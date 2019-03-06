package com.aqacourses.serenity.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsPage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]")
    private WebElement breadCrumb;

    @FindBy(xpath = "//button[@class='exclusive']")
    private WebElement addToCardButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    /**
     * Constructor
     *
     * @param driver
     */
    public DetailsPage(WebDriver driver) {
        super(driver);
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
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@id='layer_cart']"))));
    }

    /**
     * Click to Proceed to check out button
     *
     * @return instance of shopping card page
     */
    public void clickToProceedToCheckOutButton() {
        proceedToCheckoutButton.click();
    }
}
