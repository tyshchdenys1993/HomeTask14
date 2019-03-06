package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.AccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AccountPageSteps extends ScenarioSteps {

    private static final long serialVersionUID = 2404524765058352618L;

    /**
     * Constructor
     *
     * @param pages
     */
    public AccountPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get Account Page
     * @return
     */
    public AccountPage onAccountPage (){
        return pages().get(AccountPage.class);
    }

    /**
     * Click to T-Shirts button
     */
    @Step("User clicks to T-Shirts button and gets T-Shirts page")
    public void userClicksToTShirtsButtonAndGetsTShirtsPage(){
        onAccountPage().clickTShirtsButton();
    }
}
