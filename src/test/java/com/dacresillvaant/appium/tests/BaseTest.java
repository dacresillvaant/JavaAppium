package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.driver.DriverFactory;
import com.dacresillvaant.appium.listeners.TestListener;
import com.dacresillvaant.appium.pages.DialogPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
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

    protected AndroidDriver getDriver() {
        return (AndroidDriver) DriverFactory.getDriver();
    }

    private void dismissCompatibilityDialog() {
        DialogPage dialogPage = new DialogPage(getDriver());

        try {
            dialogPage.tapPositiveButton();
        } catch (NoSuchElementException e) {
            // dialog didn't appear, continue
        }
    }
}