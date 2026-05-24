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

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameErrorTV")
    private WebElement loginErrorLabel;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordErrorTV")
    private WebElement passwordErrorLabel;

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
        tap(loginButton, 3000);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }

    public String getPasswordErrorLabel() {
        return WaitUtils.waitForVisibility(driver, passwordErrorLabel, 3000).getText();
    }
    public String getUsernameErrorLabel() {
        return WaitUtils.waitForVisibility(driver, loginErrorLabel, 3000).getText();
    }
}