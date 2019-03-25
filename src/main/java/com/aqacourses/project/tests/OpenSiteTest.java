package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.AccountPage;
import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;
import org.junit.Test;

public class OpenSiteTest extends BaseTest {

    /** Open site, login and logout */
    @Test
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
}
