package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.utils.YamlParser;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement loginPageLocator;

    protected BaseTest testClass;
    private String loginPageText = "Authentication";

    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Method for login user
     *
     * @return
     */
    public AccountPage login() {

        testClass.waitTillElementIsVisible(emailField);
        emailField.sendKeys(YamlParser.getYamlData().getEmail());
        passwordField.sendKeys(YamlParser.getYamlData().getPassword());
        testClass.waitTillElementIsClickable(submitButton);
        submitButton.click();
        return new AccountPage(testClass);
    }

    /** Method for verifying that page is correct */
    public void verifyLoginPage() {
        testClass.waitTillElementIsVisible(loginPageLocator);
        Assert.assertEquals(
                "You are not on the login page", loginPageText, loginPageLocator.getText());
    }
}
