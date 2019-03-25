package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement TShirtsButton;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenButton;

    @FindBy(
            xpath =
                    "//li[@id='category-thumbnail']/preceding-sibling::li//a[@title='Evening Dresses']")
    private WebElement eveningDressesHiddenButton;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement shoppingCardDropDownList;

    @FindBy(xpath = "//span[@id='layer_cart_product_attributes']")
    private WebElement productDetails;

    @FindBy(xpath = "//span[@class='remove_link']/a")
    private WebElement removeProductFromCard;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private WebElement emptyWordInCard;

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
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Click on Sign In button
     *
     * @return instance of LoginPage
     */
    public LoginPage clickSignInButton() {
        testClass.waitTillElementIsClickable(signInButton);
        signInButton.click();
        return new LoginPage(testClass);
    }

    /**
     * Click on Sign Out button
     *
     * @return instance of LoginPage
     */
    public LoginPage clickSignOutButton() {
        testClass.waitTillElementIsClickable(logoutButton);
        logoutButton.click();
        return new LoginPage(testClass);
    }

    /** Verify that user name is correct */
    public void verifyUserName() {
        Assert.assertEquals(name + " " + surname, userName.getText());
    }

    /**
     * Click on Dresses button
     *
     * @return instance of DressesPage
     */
    public DressesPage clickToDressesButton() {
        testClass.waitTillElementIsClickable(dressesButton);
        dressesButton.click();
        return new DressesPage(testClass);
    }

    /**
     * Click on T-Shirt button
     *
     * @return
     */
    public TShirtsPage clickToTShirtsButton() {
        testClass.waitTillElementIsClickable(TShirtsButton);
        TShirtsButton.click();
        return new TShirtsPage(testClass);
    }

    /**
     * Click to hidden Evening Dresses button under Dresses button
     *
     * @return
     */
    public EveningDressesPage clickToEveningDressesPageUnderWomenCategory() {
        Actions actions = new Actions(testClass.getDriver());
        actions.moveToElement(womenButton).build().perform();
        testClass.waitTillAttributeIsChanged(
                testClass
                        .getDriver()
                        .findElement(By.xpath("//ul[contains(@class,'menu-content')]/li")),
                "class",
                "sfHover");
        eveningDressesHiddenButton.click();
        return new EveningDressesPage(testClass);
    }

    /**
     * Verify product size and color from cart
     *
     * @param expectedColor
     * @param expectedSize
     */
    public void verifyProductDetails(String expectedColor, String expectedSize) {
        Actions actions = new Actions(testClass.getDriver());
        actions.moveToElement(shoppingCardDropDownList).build().perform();

        testClass.waitTillAttributeIsChanged(
                testClass.getDriver().findElement(By.xpath("//div[contains(@class,'exclusive')]")),
                "style",
                "display: block;");

        actions.moveToElement(productDetails).build().perform();

        String color = productDetails.getText();
        String size = productDetails.getText();

        if (productDetails.isDisplayed()) {
            Assert.assertEquals(expectedColor, color.substring(color.indexOf(",")));
            Assert.assertEquals(expectedSize, size.substring(0, size.indexOf(" ")));
        }
    }

    /** Click on delete product from card */
    public void deleteProductFromCart() {
        Actions actions = new Actions(testClass.getDriver());
        actions.moveToElement(shoppingCardDropDownList).build().perform();
        removeProductFromCard.click();
    }

    /** Verify that card is empty */
    public void verifyThatCardIsEmpty() {
        String expectedEmptyWord = "(empty)";
        testClass.waitTillAttributeIsChanged(
                testClass
                        .getDriver()
                        .findElement(By.xpath("//span[@class='ajax_cart_no_product']")),
                "style",
                "display: inline-block;");
        Assert.assertEquals(expectedEmptyWord, emptyWordInCard.getText());
    }

    /** Close Window with product and back to the actual Window */
    public void closeWindowAndBackToTheAlreadyOpened() {
        testClass.getDriver().close();
        testClass.switchToActualWindow();
    }

    // Get all cookies name
    public void getCoockies() {
        Set<Cookie> cookies = testClass.getDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            System.err.println("Cookie name " + cookie.getName());
        }
    }
}
