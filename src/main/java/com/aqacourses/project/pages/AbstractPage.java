package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.aqacourses.project.base.BaseTest;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement userName;

    @FindBy(
            xpath =
                    "//ul[contains(@class,'submenu-container')]/preceding-sibling::a[@title='Dresses']")
    private WebElement dressesButton;

    @FindBy(xpath = "//a[@title='Dresses']/following::a[@title='T-shirts']")
    private WebElement tShirtsButton;

    protected BaseTest testClass;
    private String name = "Den";
    private String surname = "Tysh";

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        page(this);
    }

    /**
     * Click on Sign In button
     *
     * @return instance of LoginPage
     */
    public LoginPage clickSignInButton() {
        testClass.waitTillElementIsClickable(signInButton);
        $(signInButton).click();
        return page(LoginPage.class);
    }

    /**
     * Click on Sign Out button
     *
     * @return instance of LoginPage
     */
    public LoginPage clickSignOutButton() {
        testClass.waitTillElementIsClickable(logoutButton);
        $(logoutButton).click();
        return page(LoginPage.class);
    }

    /** Verify that user name is correct */
    public void verifyUserName() {
        $(userName).shouldBe(Condition.text(name + " " + surname));
    }

    /**
     * Click on Dresses button
     *
     * @return instance of DressesPage
     */
    public DressesPage clickToDressesButton() {
        testClass.waitTillElementIsClickable(dressesButton);
        $(dressesButton).click();
        return page(DressesPage.class);
    }

    public TShirtsPage clickToTShirtsButton() {
        testClass.waitTillElementIsClickable(tShirtsButton);
        $(tShirtsButton).click();
        return page(TShirtsPage.class);
    }
}
