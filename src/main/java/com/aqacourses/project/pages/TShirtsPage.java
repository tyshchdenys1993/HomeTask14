package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends AbstractPage {

    @FindBy(xpath = "//h5[@itemprop='name']/a")
    WebElement fadedShortSleeveTShirt;

    /**
     * Constructor
     *
     * @param testClass
     */
    public TShirtsPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Open only one available product on the web site in T-Shirt page
     * @return instance of Faded Short Sleeve T-Shirt Page
     */

    public FadedShortSleeveTShirtPage clickTotShirtProduct(){
        testClass.waitTillElementIsClickable(fadedShortSleeveTShirt);
        fadedShortSleeveTShirt.click();
        return new FadedShortSleeveTShirtPage(testClass);
    }
}
