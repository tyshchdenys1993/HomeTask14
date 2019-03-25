package com.aqacourses.project.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Class work as test suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    OpenCardTest.class,
    OpenDressesTest.class,
    OpenSiteTest.class,
    TipsAndTricksTest.class
})
public class TestSuite {}
