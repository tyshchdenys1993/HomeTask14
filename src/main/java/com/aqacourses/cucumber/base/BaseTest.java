package com.aqacourses.cucumber.base;

import com.aqacourses.cucumber.pages.HomePage;
import com.aqacourses.cucumber.utils.YamlParser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Rule public RunTestRule runTestRule = new RunTestRule(this);

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /** Constructor */
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Getter for driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Method for error logging
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    /**
     * Message for logging message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Open site
     *
     * @return
     */
    public HomePage openSite() {
        driver.get(YamlParser.getYamlData().getURL());
        return new HomePage(this);
    }

    /** Close browser */
    public void closeSite() {
        driver.quit();
    }

    /**
     * Get current Date and Time
     *
     * @return
     */
    public String getDateAndTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    /**
     * Wait till web element is visible on the page
     *
     * @param webElement
     */
    public void waitTillElementIsVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Wait till element is clickable
     *
     * @param webElement
     */
    public void waitTillElementIsClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Wait till WebElement has attribute with a specific value
     *
     * @param webElement
     * @param attribute
     * @param value
     */
    public void waitTillAttributeIsChanged(WebElement webElement, String attribute, String value) {
        wait.until(ExpectedConditions.attributeToBe(webElement, attribute, value));
    }
}
