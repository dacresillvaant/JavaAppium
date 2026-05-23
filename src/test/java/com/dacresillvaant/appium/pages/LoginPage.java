package com.dacresillvaant.appium.pages;

import com.dacresillvaant.appium.utils.WaitUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WaitUtils.waitForClickability(driver, usernameField, 3000).clear();
        WaitUtils.waitForVisibility(driver, usernameField, 3000).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForClickability(driver, passwordField, 3000).clear();
        WaitUtils.waitForVisibility(driver, passwordField, 3000).sendKeys(password);
    }

    public void tapLoginButton() {
        WaitUtils.waitForClickability(driver, loginButton, 3000).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }
}