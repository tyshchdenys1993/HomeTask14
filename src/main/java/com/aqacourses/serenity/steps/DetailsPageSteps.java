package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.DetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class DetailsPageSteps extends ScenarioSteps {

    private static final long serialVersionUID = -9134401889015719906L;

    /**
     * Constructor
     * @param pages
     */
    public DetailsPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get Details page
     * @return
     */
    public DetailsPage onDetailsPage(){
        return pages().get(DetailsPage.class);
    }

    /**
     * Verify that breadcrumb is correct
     * @param breadCrumbText
     */
    @Step ("User opens Product details page and verifies that breadcrumb is correct")
    public void userOpensProductDetailsPageAndVerifiesThatBreadCrumbIsCorrect(String breadCrumbText){
        onDetailsPage().verifyBreadCrumb(breadCrumbText);
    }

    /**
     * Click to Add to Card Button
     */
    @Step ("User click to Add to Card button")
    public void userClicksToAddToCardButton(){
        onDetailsPage().clickAddToCardButton();

    }

    /**
     * Click to Shopping Card Page
     */
    @Step ("User clicks to proceed to checkout button and gets Shopping Card Page")
    public void userClicksToProceedToCheckOutButtonAndGetsShoppingCardPage(){
        onDetailsPage().clickToProceedToCheckOutButton();
    }
}
