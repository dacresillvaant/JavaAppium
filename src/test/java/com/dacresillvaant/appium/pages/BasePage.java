package com.dacresillvaant.appium.pages;

import com.dacresillvaant.appium.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public abstract class BasePage {

    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected boolean isDisplayed(WebElement element, int millis) {
        try {
            WaitUtils.waitForVisibility(driver, element, millis);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void scrollToBottom(int numberOfMaxSwipes) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(%d)".formatted(numberOfMaxSwipes)));
    }


    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void tap(WebElement element, int millis) {
        log.info("Tapping on element: {}", element);
        WaitUtils.waitForClickability(driver, element, millis).click();
    }

    protected String getText(WebElement element, int millis) {
        return WaitUtils.waitForVisibility(driver, element, millis).getText();
    }
}