package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.enums.Categories;
import com.aqacourses.project.pages.*;
import org.junit.Test;

public class OpenCardTest extends BaseTest {

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
