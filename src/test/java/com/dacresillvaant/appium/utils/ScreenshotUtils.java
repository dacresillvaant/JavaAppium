package com.dacresillvaant.appium.utils;

import com.dacresillvaant.appium.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static lombok.AccessLevel.PRIVATE;
import static org.openqa.selenium.OutputType.FILE;

@Slf4j
@NoArgsConstructor(access = PRIVATE)
public class ScreenshotUtils {

    public static void takeScreenShot(String testName) {
        try {
            AndroidDriver driver = (AndroidDriver) DriverFactory.getDriver();
            if (driver == null) {
                log.warn("Driver is null, cannot take the screenshot");
                return;
            }

            File screenshot = driver.getScreenshotAs(FILE);
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String fileName = testName + "_" + timeStamp + ".png";

            File destination = new File("target/screenshots/" +  fileName);
            destination.getParentFile().mkdirs();
            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            log.info("Screenshot saved: {}", destination);
        } catch (IOException e) {
            log.error("Failed to save screenshot: ", e);
        }
    }
}