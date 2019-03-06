package com.aqacourses.serenity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TShirtsPage extends AbstractPage {

    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";

    /**
     * Constructor
     *
     * @param driver
     */
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }


    public void clickToProductForDetails(String productName) {
        getDriver().findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName))).click();
    }
}
