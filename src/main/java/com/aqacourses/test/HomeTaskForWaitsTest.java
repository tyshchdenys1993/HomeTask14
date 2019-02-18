package com.aqacourses.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeTaskForWaitsTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private final String URL = "https://s1.demo.opensourcecms.com/s/44";
    private final String USER_NAME_FIELD_XPATH = "//input[@id='txtUsername']";
    private final String PASSWORD_FIELD_XPATH = "//input[@id='txtPassword']";
    private final String LOGIN_BUTTON_XPATH = "//input[@id='btnLogin']";
    private final String ERROR_MESSAGE_XPATH = "//span[@id='spanMessage']";
    private final String REMOVE_FRAME_BUTTON = "//div[@class='preview__action--close']/a";

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.ignoring(TimeoutException.class).withMessage("Can't find elements");
    }

    @Test
    public void testHomeTaskForWaitsTest(){

        driver.get(URL);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE_FRAME_BUTTON))).click();
        Assert.assertFalse(isElementPresent(By.xpath("//div[@class='preview__header']")));

        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(USER_NAME_FIELD_XPATH))))
                .sendKeys("randomUserName");
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys("randomPassword");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(LOGIN_BUTTON_XPATH))))
                .click();

        Assert.assertEquals("Invalid credentials",driver.findElement(By.xpath(ERROR_MESSAGE_XPATH)).getText());

        driver.findElement(By.xpath(USER_NAME_FIELD_XPATH)).clear();
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).clear();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)))).click();

        Assert.assertEquals("Username cannot be empty", driver.findElement(By.xpath(ERROR_MESSAGE_XPATH)).getText());

        driver.findElement(By.xpath(USER_NAME_FIELD_XPATH)).sendKeys("SomeUsername");
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();

        Assert.assertEquals("Password cannot be empty", driver.findElement(By.xpath(ERROR_MESSAGE_XPATH)).getText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
