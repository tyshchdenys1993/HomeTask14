package com.aqacourses.project.tests;

import com.aqacourses.project.pages.AccountPage;
import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenSiteTest {

    private WebDriver driver;
    private String URL = "http://automationpractice.com/index.php";
    /**
     * Set up method
     */
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    /**
     * Open site, login and logout
     *
     */
    @Test
    public void testOpenSiteTest(){

        driver.get(URL);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignInButton();
        AccountPage accountPage = loginPage.login();
        accountPage.verifyUserName();
        accountPage.clickSignOutButton();
        loginPage.verifyLoginPage();
    }
    /**
     * Quit the driver
     */
    @After
    public void tearDown(){
        driver.quit();
    }
}
