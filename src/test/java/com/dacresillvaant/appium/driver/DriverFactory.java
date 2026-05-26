package com.dacresillvaant.appium.driver;

import com.dacresillvaant.appium.utils.WaitUtils;
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

    private static final String APPIUM_URL = "http://127.0.0.1:4723";
    private static final String APPLICATION_PATH = "src/test/resources/sample_app.apk";

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void createAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Emulator");
        options.setApp(Paths.get(APPLICATION_PATH).toAbsolutePath().toString());
        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(30));

        int attempts = 3;
        while (attempts > 0) {
            try {
                log.info("Creating Android Driver, attempts left: {}", attempts);
                driver.set(new AndroidDriver(URI.create(APPIUM_URL).toURL(), options));
                log.info("Android Driver created");
                return;
            } catch (MalformedURLException e) {
                log.error("Make sure that Appium server has been started and the URL is correct");
                throw new RuntimeException("Appium server URL is invalid", e);
            } catch (Exception e) {
                attempts--;
                if (attempts == 0) {
                    log.error("Failed to create Android driver after all attempts", e);
                    throw new RuntimeException("Failed to create Android driver", e);
                }
                log.warn("Failed to create driver, retrying... attempts left: {}", attempts);
                WaitUtils.sleep(3000);
            }
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