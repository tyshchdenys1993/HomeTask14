package com.aqacourses.project.tests;


import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.AccountPage;
import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;

import org.junit.Test;

public class OpenSiteSelenideTest extends BaseTest {

    @Test
    public void testOpenSiteSelenideTest() {

        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        AccountPage accountPage = loginPage.login();
        accountPage.verifyUserName();
        accountPage.clickSignOutButton();
        loginPage.verifyLoginPage();
        closeSite();
    }

}
