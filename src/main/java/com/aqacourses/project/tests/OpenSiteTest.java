package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.AccountPage;
import com.aqacourses.project.pages.DressesPage;
import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;
import org.junit.Test;

public class OpenSiteTest extends BaseTest {

    /**
     * Open site, login and logout
     *
     */
    @Test
    public void testOpenSiteTest(){

        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        AccountPage accountPage = loginPage.login();
        accountPage.verifyUserName();
        accountPage.clickSignOutButton();
        loginPage.verifyLoginPage();
        closeSite();
    }

    /**
     * Open site, login, go to Dresses page, choose only white colors dresses and verify that quantity is correct.
     * Then click to white color filter button and verify quantity again
     */
    @Test
    public void testOpenDressPage (){

        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        AccountPage accountPage = loginPage.login();
        DressesPage dressesPage = accountPage.clickToDressesButton();
        dressesPage.clickToSummerDressesButton();
        dressesPage.verifyCountOfProductsOnDressesPage();
        dressesPage.clickToWhiteColorFilterButton();
        dressesPage.verifyCountOfProductsOnDressesPage();
        closeSite();
    }
}
