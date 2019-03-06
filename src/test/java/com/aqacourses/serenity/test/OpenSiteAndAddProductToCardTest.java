package com.aqacourses.serenity.test;


import com.aqacourses.serenity.enums.Categories;
import com.aqacourses.serenity.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(SerenityRunner.class)
public class OpenSiteAndAddProductToCardTest {

    @Managed
    WebDriverWait wait;

    @Managed
    WebDriver driver;

    @ManagedPages
    Pages pages;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    AccountPageSteps accountPageSteps;

    @Steps
    TShirtsPageSteps tShirtsPageSteps;

    @Steps
    DetailsPageSteps detailsPageSteps;

    @Steps
    ShoppingCardPageSteps shoppingCardPageSteps;

    @Test
    public void testOpenSiteAndAddProductToCardTest(){
        // Open Site
        homePageSteps.userOpensSiteAndGetsHomePage();

        // Open Sign In page
        homePageSteps.userClickToSignInButtonAndOpensLoginPage();

        // Fill e-mail field
        loginPageSteps.userEnterEmail();

        // Fill password field
        loginPageSteps.userEnterPassword();

        // Click to Submit button and open My Account page
        loginPageSteps.userClicksToSubmitButtonAndGetsAccountPage();

        // Click to T-Shirts button and open T-Shirts page
        accountPageSteps.userClicksToTShirtsButtonAndGetsTShirtsPage();

        // Open Faded Short Sleeve T-shirts product
        tShirtsPageSteps.userClickToProductAndGetsProductDetailsPage("Faded Short Sleeve T-shirts");

        //  Verify breadcrumb
        detailsPageSteps.userOpensProductDetailsPageAndVerifiesThatBreadCrumbIsCorrect(
                Categories.WOMEN.getCategoryName()
                +Categories.TOPS.getCategoryName()
                +Categories.TSHIRTS.getCategoryName());

        // Add to Card
        detailsPageSteps.userClicksToAddToCardButton();

        // Click to Check out
        detailsPageSteps.userClicksToProceedToCheckOutButtonAndGetsShoppingCardPage();

        //Increase quantity
        shoppingCardPageSteps.userClickToIncreaseQuantityButton();

        // Verify price increasing
        shoppingCardPageSteps.userVerifyThatPriceIncreasedCorrectlyAfterIncreasingQuantity();

        // Delete added product
        shoppingCardPageSteps.userDeletedAddedProduct();

        // Verify that alert message is correct
        shoppingCardPageSteps.userVerifiesThatAlertMessageIsCorrectAfterDeletingProduct();
    }
}
