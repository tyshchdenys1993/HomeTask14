package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]")
    WebElement breadCrumb;

    @FindBy(xpath = "//button[@class='exclusive']")
    WebElement addToCardButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement productName;

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
                breadCrumbText + $(productName).text(),
                $(breadCrumb).text().replaceAll("[^a-zA-Z-\\s]", "").trim());
    }

    /** Method for clicking to Add button */
    public void clickAddToCardButton() {
        $(addToCardButton).click();
    }

    /**
     * Click to Proceed to check out button
     *
     * @return instance of shopping card page
     */
    public ShoppingCardPage clickToProceedToCheckOutButton() {
        testClass.waitTillElementIsVisible(proceedToCheckoutButton);
        $(proceedToCheckoutButton).click();
        return page(ShoppingCardPage.class);
    }
}
