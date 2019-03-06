package com.aqacourses.serenity.steps;

import com.aqacourses.serenity.pages.TShirtsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class TShirtsPageSteps extends ScenarioSteps {

    private static final long serialVersionUID = -6908869097959898997L;

    /**
     * Constructor
     * @param pages
     */
    public TShirtsPageSteps(Pages pages) {
        super(pages);
    }

    /**
     *  Get T-Shirts page
     * @return TShirtsPage
     */
    public TShirtsPage onTShirtsPage (){
        return pages().get(TShirtsPage.class);
    }

    /**
     * Click to product on the page and open details page
     * @param productName
     */
    @Step ("User clicks to Product and gets product details page")
    public void userClickToProductAndGetsProductDetailsPage(String productName){
        onTShirtsPage().clickToProductForDetails(productName);
    }
}
