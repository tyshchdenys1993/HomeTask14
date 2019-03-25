package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.*;
import org.junit.Test;

public class OpenDressesTest extends BaseTest {
    /**
     * Open site, login, go to Dresses page, choose only white colors dresses and verify that
     * quantity is correct. Then click to white color filter button and verify quantity again
     */
    @Test
    public void testOpenDressTest() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In button
        LoginPage loginPage = homePage.clickSignInButton();
        log("Opened Login Page");

        // Login
        AccountPage accountPage = loginPage.login();
        log("Opened My Account Page");

        // Open Dresses page by clicking to dresses button
        DressesPage dressesPage = accountPage.clickToDressesButton();
        log("Opened Dresses Page");

        // Open Summer dresses page by clicking to summer dresses button
        SummerDressesPage summerDressesPage = dressesPage.clickToSummerDressesButton();
        log("Opened Summer Dresses Page");

        // Verify count of products
        summerDressesPage.verifyCountOfProductsOnDressesPage();
        log("Verified count of products from the message and from page");

        // Clicking to White Color filter
        summerDressesPage.clickToWhiteColorFilterButton();
        log("Selected only White dresses");

        // Verify Count of products for white dresses
        summerDressesPage.verifyCountOfProductsOnDressesPage();
        log("Verified count of products from the message and from page again");

        // Close site
        closeSite();
        log("Closed site");
    }
}
