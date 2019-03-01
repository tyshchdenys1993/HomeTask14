package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.enums.Categories;
import com.aqacourses.project.pages.*;
import org.junit.Ignore;
import org.junit.Test;

public class OpenSiteTest extends BaseTest {

    /** Open site, login and logout */
    @Test
    @Ignore
    public void testOpenSiteTest() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In button
        LoginPage loginPage = homePage.clickSignInButton();
        log("Opened Login Page");

        // Login
        AccountPage accountPage = loginPage.login();
        log("Opened My Account Page");

        // Verify username
        accountPage.verifyUserName();
        log("Verified user name");

        // Sign user out
        accountPage.clickSignOutButton();
        log("User is signed out");

        // Verify that after signing out Login page is opened
        loginPage.verifyLoginPage();
        log("Verified Login Page");

        // Close site
        closeSite();
        log("Closed site");
    }

    /**
     * Open site, login, go to Dresses page, choose only white colors dresses and verify that
     * quantity is correct. Then click to white color filter button and verify quantity again
     */
    @Test
    @Ignore
    public void testOpenDressPage() {

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

    /** Open site, Open T-Shirts page and add it to Card */
    @Test
    public void testOpenCardTest() {
        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In button
        LoginPage loginPage = homePage.clickSignInButton();
        log("Opened Login Page");

        // Login
        AccountPage accountPage = loginPage.login();
        log("Opened My Account Page");

        // Open T-Shirts page by clicking to T-Shirts button
        TShirtsPage tShirtsPage = accountPage.clickToTShirtsButton();
        log("Opened T-Shirts Page");

        // Open Faded Short sleeve T-Shirt Page
        DetailsPage detailsPage =
                tShirtsPage.clickToProductForDetails("Faded Short Sleeve T-shirts");
        log("Opened Faded Short sleeve T-Shirt Page");

        // Verify breadcrumb
        detailsPage.verifyBreadCrumb(
                Categories.WOMEN.getCategoryName()
                        + Categories.TOPS.getCategoryName()
                        + Categories.TSHIRTS.getCategoryName());
        log("Verified breadcrumb");

        // Add Faded Short Sleeve T-Shirt
        detailsPage.clickAddToCardButton();
        log("Opened information dialog");

        // Click to Proceed To Check Out Button and open Shopping Card Page
        ShoppingCardPage shoppingCardPage = detailsPage.clickToProceedToCheckOutButton();
        log("Opened shopping card page");

        // Increase quantity
        shoppingCardPage.clickToIncreaseQuantityButton();
        log("Clicked Increase quantity button");

        // Verify price after increasing quantity
        shoppingCardPage.verifyPriceIncreasing();
        log("Verified total price with unit price multiplied with quantity");

        // Delete added products
        shoppingCardPage.clickDeleteFadedTShort();
        log("Deleted Faded Short sleeve T-Shirt");

        // Verify alert
        shoppingCardPage.verifyAlertMessage();
        log("Verified alert message");

        // Close site
        closeSite();
        log("Closed site");
    }
}
