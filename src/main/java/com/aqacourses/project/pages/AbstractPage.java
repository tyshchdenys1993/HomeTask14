package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy (xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement userName;

    @FindBy (xpath = "//ul[contains(@class,'submenu-container')]/preceding-sibling::a[@title='Dresses']")
    private WebElement dressesButton;



    protected BaseTest testClass;
    private String name = "Den";
    private String surname ="Tysh";

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Click on Sign In button
     *
     * @return
     */
    public LoginPage clickSignInButton(){
        testClass.waitTillElementIsClickable(signInButton);
        signInButton.click();
        return new LoginPage(testClass);
    }

    /**
     * Click on Sign Out button
     *
     * @return instance of LoginPage
     */
    public LoginPage clickSignOutButton(){
        testClass.waitTillElementIsClickable(logoutButton);
        logoutButton.click();
        return new LoginPage(testClass);
    }

    /**
     * Verify that user name is correct
     */
    public void verifyUserName(){
        Assert.assertEquals(name + " " + surname, userName.getText());
    }

    /**
     * Click on Dresses button
     *
     * @return instance of DressesPage
     */

   public DressesPage clickToDressesButton(){
        testClass.waitTillElementIsClickable(dressesButton);
        dressesButton.click();
        return new DressesPage(testClass);
   }
}
