package com.aqacourses.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement submitButton;

    @FindBy (xpath = "//span[@class='navigation_page']")
    private WebElement loginPageLocator;

    private WebDriver driver;
    private WebDriverWait wait;
    private String email = "tisden64@gmail.com";
    private String password = "pa55word1111";
    private String loginPageText = "Authentication";

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Method for email entering
     * @param email
     * @return
     */
    public LoginPage enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        return this;
    }

    /**
     * Method for password entering
     * @param password
     * @return
     */

    public LoginPage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        return this;
    }

    /**
     * Method for clicking to Submit button
     * @return
     */
    public AccountPage clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return new AccountPage(driver);
    }

    /**
     * Method for login user
     * @return
     */
    public AccountPage login(){
        this.enterEmail(email);
        this.enterPassword(password);
        this.clickSubmitButton();
        return new AccountPage(driver);
    }

    /**
     * Method for verifying that page is correct
     */
    public void verifyLoginPage(){
        Assert.assertEquals("You are not on the login page", loginPageText,wait.until(ExpectedConditions.visibilityOf(loginPageLocator)).getText() );
    }
}
