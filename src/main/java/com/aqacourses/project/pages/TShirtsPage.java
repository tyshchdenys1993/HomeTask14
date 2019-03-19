package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.aqacourses.project.base.BaseTest;

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
                $(byXpath(String.format(PRODUCT_DETAILS_XPATH, productName))));

        $(byXpath(String.format(PRODUCT_DETAILS_XPATH, productName))).click();
        return page(DetailsPage.class);
    }
}
