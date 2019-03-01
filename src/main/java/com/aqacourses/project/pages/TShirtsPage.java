package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.openqa.selenium.By;

public class TShirtsPage extends AbstractPage {
    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";


    /**
     * Constructor
     *
     * @param testClass
     */
    public TShirtsPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Open only one available product on the web site in T-Shirt page
     *
     * @return instance of product Page
     */
    public DetailsPage clickToProductForDetails(String productName) {
        testClass.waitTillElementIsClickable(
                testClass
                        .getDriver()
                        .findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName))));
        testClass
                .getDriver()
                .findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName)))
                .click();
        return new DetailsPage(testClass);
    }
}
