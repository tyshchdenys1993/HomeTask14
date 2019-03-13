package com.aqacourses.cucumber.pages;

import com.aqacourses.cucumber.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@title='Dresses']/following::a[@title='T-shirts']")
    private WebElement TShirtsButton;

    protected BaseTest testClass;

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
     * Method for clicking to loginButton
     *
     * @return LoginPage
     */
    public LoginPage clickToLoginButton() {
        testClass.waitTillElementIsClickable(loginButton);
        loginButton.click();
        return new LoginPage(testClass);
    }

    /**
     * Method for clicking to T-Shirts button
     *
     * @return TShirtPage
     */
    public TShirtPage clickToTShirtsbutton() {
        testClass.waitTillElementIsClickable(TShirtsButton);
        TShirtsButton.click();
        return new TShirtPage(testClass);
    }
}
