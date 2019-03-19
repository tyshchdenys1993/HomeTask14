package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

import com.aqacourses.project.base.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends AbstractPage {

    @FindBy(xpath = "//div/a[@title='Summer Dresses']")
    private WebElement summerDressesButton;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement countOfProductsTextField;

    @FindBy(xpath = "//input[@id='layered_id_attribute_group_8']")
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
        page(this);
    }

    /** Click to Summer Dresses button */
    public SummerDressesPage clickToSummerDressesButton() {
        testClass.waitTillElementIsClickable(summerDressesButton);
        $(summerDressesButton).click();
        return page(SummerDressesPage.class);
    }

    /** Click to White color filter button */
    public void clickToWhiteColorFilterButton() {
        testClass.waitTillElementIsClickable(whiteColorFilterButton);
        $(whiteColorFilterButton).click();
    }

    /** Verify, that count o items in text field corresponds to count of products on the page */
    public void verifyCountOfProductsOnDressesPage() {
        testClass.waitTillElementIsVisible(countOfProductsTextField);
        countOfProductsOnThePage =
                Integer.parseInt($(countOfProductsTextField).text().replaceAll("[^0-9]", ""));

        ElementsCollection products = $$(byXpath("//ul[contains(@class,'product_list')]/li"));
        Assert.assertEquals(countOfProductsOnThePage, products.size());
    }
}
