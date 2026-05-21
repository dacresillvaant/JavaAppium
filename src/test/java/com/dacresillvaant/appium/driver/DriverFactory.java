package com.dacresillvaant.appium.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Paths;
import java.time.Duration;

@Slf4j
public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void createAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Emulator");
        options.setApp(Paths.get("src/test/resources/sample_app.apk").toAbsolutePath().toString());
        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        try {
            log.info("Creating Android Driver");
            driver.set(new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), options));
            log.info("Android Driver created");
        } catch (MalformedURLException e) {
            log.error("Make sure that Appium server has been started and the URL is correct");
            throw new RuntimeException("Appium server URL is invalid", e);
        } catch (Exception e) {
            log.error("Failed to create Android driver", e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            log.info("Quitting Android Driver");
            driver.get().quit();
            driver.remove();
            log.info("Android driver quitted");
        }
    }
}