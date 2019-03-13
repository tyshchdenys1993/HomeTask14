package com.aqacourses.cucumber.tests;

import com.aqacourses.cucumber.base.BaseTest;
import com.aqacourses.cucumber.enums.Categories;
import com.aqacourses.cucumber.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TestClassCucumber extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private TShirtPage tShirtPage;
    private ProductDetailsPage productDetailsPage;
    private ShoppingCartPage shoppingCartPage;
    private Categories categories;
    private String actualBreadCrumb;
    private Double actualTotalPrice;
    private String actualAlert;

    @Given("The user opens site sees Home Page")
    public void theUserOpenSiteAndSeesHomePage(){
        homePage = openSite();
    }
    @When("He clicks Sign In link sees Login page")
    public void heClicksSignInLinkAndSeesLoginPage(){
        loginPage = homePage.clickToLoginButton();
    }
    @When("He loging in sees account page")
    public void heLogingInAndSeesAcountPage(){
        accountPage = loginPage.login();
    }
    @When("He clicks to T-Shirts button sees T-Shirts Page")
    public void heClicksToTShirtsButtonAndSeesTShirtsPage(){
        tShirtPage = accountPage.clickToTShirtsbutton();
    }
    @When("He clicks to '([^\"]*)' sees Product Details Page")
    public void heClicksToFadedShortSleeveTShirtsButtonAnsSeesProductDetailsPage(String productName){
        productDetailsPage = tShirtPage.clickToProductForDetails(productName);
    }
    @When("He verify breadcrumb on Product Details Page")
    public void heVerifyBreadCrumb(){
        actualBreadCrumb = productDetailsPage.getBreadCrumbText();
    }
    @Then("Breadcrumb is correct")
    public void breadCrumbIs(){
        Assert.assertEquals(categories.WOMEN.getCategoryName()
                + categories.TOPS.getCategoryName()
                + categories.TSHIRTS.getCategoryName()
                + productDetailsPage.getProductName(), actualBreadCrumb);
    }
    @When("He clicks to Add to Cart sees dialog with product")
    public void heClicksToAddToCardButtonAndSeesDialogWithProduct(){
        productDetailsPage.clickToAddToCartButton();
    }
    @When("He clicks to Proceed to Checkout button sees Shopping Cart Page")
    public void heClicksToProceedToCheckOutButtonAndSeesShoppingCartPage(){
        shoppingCartPage = productDetailsPage.clickToProceedToCheckoutButton();
    }
    @When("He clicks to \"+\" button quntity should be increased by 1")
    public void heClicksToProceedToCheckOutButtonAndQuantityIncreased(){
        shoppingCartPage.clickToIncreaseQuantityButton();
        actualTotalPrice = shoppingCartPage.getTotalPrice();
    }
    @Then("Total price should be increased")
    public void totalPriceIsIncreased(){
        Assert.assertEquals(shoppingCartPage.getExpectedPrice(), actualTotalPrice);
    }
    @When("He deletes product from Cart")
    public void heDeletedProductFromcart(){
        shoppingCartPage.clickDeleteFadedTShort();
        actualAlert = shoppingCartPage.getAlertMessage();
    }

    @Then("Alert is '([^\"]*)'")
    public void alertIs(String expectedAlertMessage){
        Assert.assertEquals(expectedAlertMessage, actualAlert);
    }

    @Then("User closes browser")
    public void userClosesBrowser() {
        closeSite();
    }
}
