package com.aqacourses.project.base;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class RunTestRule extends TestWatcher {

    private BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public RunTestRule(BaseTest testClass) {
        this.testClass = testClass;
    }

    /**
     * Make screenshot and make driver.quit() Overriding this method you can add some actions on
     * test failing
     *
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {
        // Write down to log file error message
        testClass.error(e.getMessage());

        // Driver quit on fail
        testClass.getDriver().quit();
    }

    /**
     * Make getDriver.quit()(whether passing or failing)
     *
     * @param description
     */
    @Override
    protected void finished(Description description) {
        testClass.getDriver().quit();
    }
}
