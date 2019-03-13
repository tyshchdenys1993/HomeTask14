package com.aqacourses.cucumber.pages;

import com.aqacourses.cucumber.base.BaseTest;
import org.openqa.selenium.By;

public class TShirtPage extends AbstractPage {

    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";
    /**
     * Constructor
     *
     * @param testClass
     */
    public TShirtPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Click to the only one product on T-Shirts page
     *
     * @param productName
     * @return ProductDetailsPage
     */
    public ProductDetailsPage clickToProductForDetails(String productName) {
        testClass.waitTillElementIsClickable(
                testClass
                        .getDriver()
                        .findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName))));
        testClass
                .getDriver()
                .findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName)))
                .click();
        return new ProductDetailsPage(testClass);
    }
}
