package com.aqacourses.cucumber.base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
     * Close browser if test finished (passed or failed)
     *
     * @param description
     */
    @Override
    protected void finished(Description description) {
        testClass.closeSite();
    }

    /**
     * Create screenshot under specified directory and close browser if test if failed
     *
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {
        String baseDir = "src/main/resources/screenshots";
        File directory = new File(baseDir);

        if (!directory.exists()) {
            directory.mkdir();
        }

        String className = description.getTestClass().getSimpleName();
        String methodName = description.getMethodName();

        String screenshotName =
                baseDir
                        + "/"
                        + className
                        + "-"
                        + methodName
                        + "-"
                        + testClass.getDateAndTime()
                        + ".png";

        File targetFile = new File(screenshotName);

        try {
            FileUtils.copyFile(
                    ((TakesScreenshot) testClass.getDriver()).getScreenshotAs(OutputType.FILE),
                    targetFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // Write down to log file error message
        testClass.error(e.getMessage());

        // Driver quit on fail

        testClass.getDriver().quit();
    }
}
