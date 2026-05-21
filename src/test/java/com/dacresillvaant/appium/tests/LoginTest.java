package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testDriverInitialization() {
        Assert.assertNotNull(DriverFactory.getDriver());
    }
}