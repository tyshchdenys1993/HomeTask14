package com.aqacourses.project.base;

import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.utils.YamlParser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Rule public RunTestRule runTestRule = new RunTestRule(this);

    @Rule public ScreenShooter screenShooter = ScreenShooter.failedTests();

    /** Constructor */
    public BaseTest() {

        Configuration.startMaximized = true;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
//        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);
//
//        setWebDriver(driver);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return getWebDriver();
    }

    /**
     * Write down info message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    /**
     * Get current date and time
     *
     * @return
     */
    public String getDateAndTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite() {
        open(YamlParser.getYamlData().getUrl());
        return page(HomePage.class);
    }

    /** Driver quit */
    public void closeSite() {
        close();
    }

    /**
     * Wait till element is visible
     *
     * @param webElement
     */
    public void waitTillElementIsVisible(WebElement webElement) {
        $(webElement).is(Condition.visible);
    }

    /**
     * Wait till element is clickable
     *
     * @param webElement
     */
    public void waitTillElementIsClickable(WebElement webElement) {
        $(webElement).is(Condition.enabled);
    }

    /**
     * Wait till WebElement has attribute with a specific value
     *
     * @param webElement
     * @param attribute
     * @param value
     */
    public void waitTillAttributeIsChanged(WebElement webElement, String attribute, String value) {
        $(webElement).is(Condition.attribute(attribute, value));
    }
}
