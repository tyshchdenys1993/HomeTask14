package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    private static final long serialVersionUID = 274692673467901665L;

    /**
     * Constructor
     * @param pages
     */
    public HomePageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get HomePage
     * @return
     */
    public HomePage onHomePage (){
        return pages().get(HomePage.class);
    }

    /**
     * Open Site
     */
    @Step("User opens site and gets home page")
    public void userOpensSiteAndGetsHomePage(){
        onHomePage().openSite();
    }

    @Step
    public void userClickToSignInButtonAndOpensLoginPage(){
        onHomePage().clickSignInButton();
    }
}
