package com.aqacourses.serenity.pages;

import com.aqacourses.serenity.utils.YamlParser;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractPage extends PageObject {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@title='Dresses']/following::a[@title='T-shirts']")
    private WebElement tShirtsButton;

    /**
     * Constructor
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open site with url from yaml file
     */
    public void openSite(){
        getDriver().manage().window().maximize();
        getDriver().get(YamlParser.getYamlData().getUrl());
    }

    /**
     * Click SighIn button
     */
    public void clickSignInButton(){
        signInButton.click();
    }

    /**
     * Click T-Shirts button
     */
    public void clickTShirtsButton(){
        tShirtsButton.click();
    }

}
