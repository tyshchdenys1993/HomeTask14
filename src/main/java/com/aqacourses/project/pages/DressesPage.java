package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DressesPage extends AbstractPage {

    @FindBy(xpath = "//div/a[@title='Summer Dresses']")
    private WebElement summerDressesButton;

    @FindBy (xpath = "//span[@class='heading-counter']")
    private WebElement countOfProductsTextField;

    @FindBy (xpath = "//input[@id='layered_id_attribute_group_8']")
    private WebElement whiteColorFilterButton;

    private BaseTest testClass;
    private int countOfProductsOnThePage;

    /**
     * Constructor
     *
     * @param testClass
     */
    public DressesPage(BaseTest testClass) {
        super(testClass);
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    /**
     * Click to Summer Dresses button
     */

    public void clickToSummerDressesButton (){
        testClass.waitTillElementIsClickable(summerDressesButton);
        summerDressesButton.click();
    }

    /**
     * Click to White color filter button
     */
    public void clickToWhiteColorFilterButton(){
        testClass.waitTillElementIsClickable(whiteColorFilterButton);
        whiteColorFilterButton.click();
    }

    /**
     * Verify, that count o items in text field corresponds to count of products on the page
     */
    public void verifyCountOfProductsOnDressesPage(){
        testClass.waitTillElementIsVisible(countOfProductsTextField);
        countOfProductsOnThePage = Integer.parseInt(countOfProductsTextField.getText().replaceAll("[^0-9]", ""));
        List <WebElement> products = testClass.getDriver().findElements(By.xpath("//ul[contains(@class,'product_list')]/li"));
        Assert.assertEquals(countOfProductsOnThePage, products.size());
    }
}
