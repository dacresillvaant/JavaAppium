package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.createAndroidDriver();
        dismissCompatibilityDialog(); // Sauce Labs demo app triggers this dialog
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    private void dismissCompatibilityDialog() {
        try {
            WebElement okButton = DriverFactory.getDriver().findElement(AppiumBy.id("android:id/button1"));
            okButton.click();
        } catch (NoSuchElementException e) {
            // dialog didn't appear, continue
        }
    }
}