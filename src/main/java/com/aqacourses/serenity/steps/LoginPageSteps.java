package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginPageSteps extends ScenarioSteps {

    private static final long serialVersionUID = -1750384416464873025L;

    /**
     * Constructor
     * @param pages
     */
    public LoginPageSteps(Pages pages) {
        super(pages);
    }

    /**
     * Get Login Page
     * @return
     */
    public LoginPage onLoginPage(){
        return pages().get(LoginPage.class);
    }

    /**
     * Enter e-mail
     */
    @Step("User enter his email")
    public void userEnterEmail(){
        onLoginPage().enterEmail();
    }

    /**
     * Enter Password
     */
    @Step("User enter his password")
    public void userEnterPassword(){
        onLoginPage().enterPassword();
    }

    /**
     * Click To submit button
     */
    @Step("User clicks to submit button and gets account page")
    public void userClicksToSubmitButtonAndGetsAccountPage(){
        onLoginPage().clickToSubmitButton();
    }
}
