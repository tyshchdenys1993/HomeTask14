package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;

import static com.codeborne.selenide.Selenide.page;

public class HomePage extends AbstractPage {


    /**
     * Constructor
     *
     * @param testClass
     */
    public HomePage(BaseTest testClass) {
        super(testClass);
        page(this);
    }
}
