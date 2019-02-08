package com.aqacourses.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenGoogleTest {

    private WebDriver driver;

    /**
     * Before test, set up method
     */
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Open Google page, search for 'Automation testing' and open 'https://www.qasymphony.com' link
     */
    @Test
    public void testOpenGoogleTest(){
        driver.get("https:/google.com.ua");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation testing", Keys.ENTER);

        /* another way to clicking Search button (without pressing ENTER)
        driver.findElement(By.xpath("//div[@class='VlcLAe']//input[contains(@value,'Google')]")).click();
        */

        driver.findElement(By.xpath("//div/a[contains(@href,'https://www.qasymphony.com')]")).click();
    }

    /**
     * After method, quit driver
     */
    @After
    public void tearDown(){
        driver.quit();
    }
}
