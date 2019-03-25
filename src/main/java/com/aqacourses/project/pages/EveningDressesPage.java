package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EveningDressesPage extends AbstractPage {
    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";

    /**
     * Constructor
     *
     * @param testClass
     */
    public EveningDressesPage(BaseTest testClass) {
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
                .sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        testClass.switchToNewWindow();
        return new DetailsPage(testClass);
    }
}
