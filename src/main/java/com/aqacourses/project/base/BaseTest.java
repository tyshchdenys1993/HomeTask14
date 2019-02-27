package com.aqacourses.project.base;

import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.utils.YamlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Rule
    public RunTestRule runTestRule = new RunTestRule(this);

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * Constructor
     *
     */
    public BaseTest()      {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Return instance of Driver
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Write down info message
     *
     * @param message
     */
    public void log (String message){
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    public void error (String error){
        logger.error(error);
    }

    /**
     * Get current date and time
     * @return
     */
    public String getDateAndTime(){
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite(){
        driver.get(YamlParser.getYamlData().getUrl());
        return new HomePage(this);
    }

    /**
     * Driver quit
     */
    public void closeSite(){
        driver.quit();
    }

    /**
     * Wait till element is visible
     * @param webElement
     */
    public void waitTillElementIsVisible(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Wait till element is clickable
     * @param webElement
     */
    public void waitTillElementIsClickable (WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
