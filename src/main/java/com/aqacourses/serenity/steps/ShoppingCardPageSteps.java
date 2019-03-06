package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.ShoppingCardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class ShoppingCardPageSteps extends ScenarioSteps {

    private static final long serialVersionUID = -222694629013573254L;

    /**
     * Constructor
     * @param pages
     */
    public ShoppingCardPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get Shopping Card Page
     * @return
     */
    public ShoppingCardPage onShoppingCardPage(){
        return pages().get(ShoppingCardPage.class);
    }

    /**
     * Click to Increase qunatity
     */
    @Step ("User Clicks to Increase quantity button")
    public void userClickToIncreaseQuantityButton() {
        onShoppingCardPage().clickToIncreaseQuantityButton();
    }

    /**
     * Verify that price increased correctly
     */
    @Step
    public void userVerifyThatPriceIncreasedCorrectlyAfterIncreasingQuantity(){
        onShoppingCardPage().verifyPriceIncreasing();
    }

    /**
     * Click to delete button
     */
    @Step ("User clicks to delete button for deleting product")
    public void userDeletedAddedProduct(){
        onShoppingCardPage().clickDeleteFadedTShort();
    }

    /**
     * Verify alert message
     */
    @Step ("User verifies that alert message is correct after deleting product")
    public void userVerifiesThatAlertMessageIsCorrectAfterDeletingProduct(){
        onShoppingCardPage().verifyAlertMessage();
    }
}
