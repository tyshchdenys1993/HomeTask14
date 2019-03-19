package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.utils.YamlParser;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        page(this);
    }

    /**
     * Method for login user
     *
     * @return
     */
    public AccountPage login() {
        testClass.waitTillElementIsVisible(emailField);
        $(emailField).sendKeys(YamlParser.getYamlData().getEmail());
        $(passwordField).sendKeys(YamlParser.getYamlData().getPassword());
        testClass.waitTillElementIsClickable(submitButton);
        $(submitButton).click();
        return page(AccountPage.class);
    }

    /** Method for verifying that page is correct */
    public void verifyLoginPage() {
        testClass.waitTillElementIsVisible(loginPageLocator);
        $(loginPageLocator).shouldBe(Condition.text(loginPageText));
    }
}
