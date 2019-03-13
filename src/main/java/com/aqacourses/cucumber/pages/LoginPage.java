package com.aqacourses.cucumber.pages;

import com.aqacourses.cucumber.base.BaseTest;
import com.aqacourses.cucumber.utils.YamlParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement submitButton;

    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
    }

    public AccountPage login() {
        testClass.waitTillElementIsClickable(emailField);
        emailField.sendKeys(YamlParser.getYamlData().getEmail());
        passwordField.sendKeys(YamlParser.getYamlData().getPassword());
        submitButton.click();
        return new AccountPage(testClass);
    }
}
