package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.driver.DriverFactory;
import com.dacresillvaant.appium.listeners.TestListener;
import com.dacresillvaant.appium.pages.DialogPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public abstract class BaseTest {

    @BeforeMethod
    @Parameters({"udid", "emulatorPort"})
    public void setUp(@Optional("emulator-5554") String udid, @Optional("8200") int emulatorPort) {
        DriverFactory.createAndroidDriver(udid, emulatorPort);
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