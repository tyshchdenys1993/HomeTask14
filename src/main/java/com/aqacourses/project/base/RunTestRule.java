package com.aqacourses.project.base;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

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
     * Make screenshot and make driver.quit()
     * Overriding this method you can add some actions on test failing
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {

        // Path for directory with screenshots
        String baseDir = "src/main/resources/screenshots";
        File directory = new File(baseDir);

        // Create directory if it doesn't exists
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Get test class name and method name
        String className = description.getTestClass().getSimpleName();
        String methodName = description.getMethodName();

        // Create name of screenshot
        String screenshotName = baseDir + "/" + className + "-" + methodName + "-" + testClass.getDateAndTime() + ".png";

        File targetFile = new File(screenshotName);

        try {
            FileUtils.copyFile(((TakesScreenshot) testClass.getDriver()).getScreenshotAs(OutputType.FILE),
                    targetFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // Write down to log file error message
        testClass.error(e.getMessage());

        //Driver quit on fail
        testClass.getDriver().quit();
    }

    /**
     * Make getDriver.quit()(whether passing or failing)
     * @param description
     */
    @Override
    protected void finished(Description description) {
        testClass.getDriver().quit();
    }
}
