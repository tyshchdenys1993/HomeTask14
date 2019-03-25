package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.*;
import org.junit.Test;

public class TipsAndTricksTest extends BaseTest {
    /**
     * Open site, login, open evening dresses page in new tab, add it to card with "Pink" color and
     * "L" size and delete it from card. Get all cookies.
     */
    @Test
    public void testTipsAndTricksTest() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In button
        LoginPage loginPage = homePage.clickSignInButton();
        log("Opened Login Page");

        // Login
        AccountPage accountPage = loginPage.login();
        log("Opened My account page");

        // Click to Evening dresses page under women Category
        EveningDressesPage eveningDressesPage =
                accountPage.clickToEveningDressesPageUnderWomenCategory();
        log("Opened Evening dresses page");

        // Open Printed Dress on Evening Dresses Page
        DetailsPage detailsPage = eveningDressesPage.clickToProductForDetails("Printed Dress");
        log("Opened Printed Dress on new window");

        // Select "Pink" color
        detailsPage.selectProductColor("Pink");
        log("Selected 'Pink' color");

        // Select "L" size
        detailsPage.selectProductSize("L");
        log("Selected 'L' size");

        // Click to Add to Card button
        detailsPage.clickAddToCardButton();
        log("Opened informational dialog");

        // Click to Continue Shopping button
        detailsPage.clickToContinueShoppingButton();
        log("Returned to the page");

        // Verify that product in car has Pink color and L size
        detailsPage.verifyProductDetails("Pink", "L");
        log("Product color and size verified");

        // Delete product from cart
        detailsPage.deleteProductFromCart();
        log("Product deleted");

        // Verify that card is empty
        detailsPage.verifyThatCardIsEmpty();
        log("Card is empty");

        // Close window and switch to already opened
        detailsPage.closeWindowAndBackToTheAlreadyOpened();
        log("Window is closed and switched to the already opened");

        // Get cookies name
        eveningDressesPage.getCoockies();
        log("Cookies");

        // Close site
        closeSite();
        log("Closed site");
    }
}
