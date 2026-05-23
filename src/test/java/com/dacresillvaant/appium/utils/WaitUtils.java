package com.dacresillvaant.appium.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WaitUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator, int millis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int millis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForPresence(WebDriver driver, By locator, int millis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, By locator, int millis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, WebElement element, int millis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(millis));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}