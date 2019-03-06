package com.aqacourses.serenity.pages;

import com.aqacourses.serenity.utils.YamlParser;
import org.openqa.selenium.WebDriver;
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
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter e-mail
     */
    public void enterEmail(){
        emailField.sendKeys(YamlParser.getYamlData().getEmail());
    }

    /**
     * Enter Passsword
     */
    public void enterPassword(){
        passwordField.sendKeys(YamlParser.getYamlData().getPassword());
    }

    /**
     * Click to submit button for login
     */
    public void clickToSubmitButton(){
        submitButton.click();
    }
}
