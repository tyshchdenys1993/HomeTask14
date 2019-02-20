package com.aqacourses.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy (xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement userName;

    private WebDriver driver;
    private WebDriverWait wait;
    private String name = "Den";
    private String surname ="Tysh";

    /**
     * Constructor
     *
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Sign In button
     *
     * @return
     */
    public LoginPage clickSignInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new LoginPage(driver);
    }

    /**
     * Click on Sign Out button
     *
     * @return
     */
    public LoginPage clickSignOutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return new LoginPage(driver);
    }

    /**
     * Verify that user name is correct
     */
    public void verifyUserName(){
        Assert.assertEquals(name + " " + surname, userName.getText());
    }

}
