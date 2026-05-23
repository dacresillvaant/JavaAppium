package com.dacresillvaant.appium.pages;

import com.dacresillvaant.appium.utils.WaitUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DialogPage extends BasePage {

    @AndroidFindBy(id = "android:id/button1")
    private WebElement positiveButton;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement negativeButton;

    @AndroidFindBy(id = "android:id/message")
    private WebElement message;

    public DialogPage(AndroidDriver driver) {
        super(driver);
    }

    public void tapPositiveButton() {
        WaitUtils.waitForClickability(driver, positiveButton, 3000).click();
    }

    public void tapNegativeButton() {
        WaitUtils.waitForClickability(driver, negativeButton, 3000).click();
    }
}