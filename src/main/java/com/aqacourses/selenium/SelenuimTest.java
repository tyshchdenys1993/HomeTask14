package com.aqacourses.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SelenuimTest{

    private WebDriver driver;

    /**
     * Set up method
     */
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     *
     * Open https://supsystic.com/example/comparison-example/ page,
     * get and print new and old prices for Samsung Galaxy S6 and print differences between them
     * @throws InterruptedException
     */

    @Test
    public void testComparison() throws InterruptedException {
        driver.get("https://supsystic.com/example/comparison-example/");
        Thread.sleep(5000);

        double price = Double.parseDouble(driver.findElement(By.xpath("//div[contains(@class,'ptsCol-2')]//div[contains(@class,'ptsRows')]/div[last()]//span"))
                .getText()
                .replace("$",""));
        int oldPrice = Integer.valueOf(driver.findElement(By.xpath("//div[@class='ptsColFooter']/div[@class='ptsEl']//span"))
                .getText()
                .replace("$",""));


        System.out.println("Current price: " + price);
        System.out.println("Old price: " + oldPrice);
        System.out.println("Difference between new and old price: " + (oldPrice - price));
    }

    /**
     * Open https://unicode-table.com/ru/ page, found 'Q', '&', 'A' (and any symbol) and print them in console.
     * @throws InterruptedException
     */
    @Test
    public void testUnicode() throws InterruptedException {

        char symbol = 'B';
        String symbolCharacter = String.format("%04X ", (int)symbol);


        driver.get("https://unicode-table.com/ru/");
        Thread.sleep(5000);

        char symbolQ = (driver.findElement(By.xpath("//li[contains(@title,'0051')]")).getText()).charAt(0);
        char symbolAnd = (driver.findElement(By.xpath("//li[contains(@title,'0026')]")).getText()).charAt(0);
        char symbolA = (driver.findElement(By.xpath("//li[contains(@title,'0041')]")).getText()).charAt(0);
        char anySymbol = (driver.findElement(By.xpath("//li[contains(@title,'" + symbolCharacter + "')]")).getText()).charAt(0);

        System.out.println(symbolQ);
        System.out.println(symbolAnd);
        System.out.println(symbolA);
        System.out.println(anySymbol);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
